package chuco.joel.gapsi.di


import android.content.Context
import android.util.Log
import chuco.joel.gapsi.BuildConfig
import chuco.joel.gapsi.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext appContext: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor { chain ->
            val request = chain.request()

            val newRequest = request.newBuilder()
                .apply {
                    header("x-rapidapi-key", BuildConfig.API_KEY)
                }
                .build()

            chain.proceed(newRequest)
        }

        if (BuildConfig.DEBUG) {
            builder.addInterceptor { chain ->
                val request = chain.request()
                val startTime = System.nanoTime()

                val requestBody = request.body
                val bodyString = requestBody?.let {
                    val buffer = okio.Buffer()
                    it.writeTo(buffer)
                    buffer.readUtf8()
                } ?: "No Body"

                Log.d(
                    "API_REQUEST", """
                --> Request ${request.method} ${request.url}
                Headers: ${request.headers}
                Body: $bodyString
            """.trimIndent()
                )

                val response = chain.proceed(request)
                val endTime = System.nanoTime()

                val responseBody = response.body
                val responseBodyString = responseBody?.string() ?: "No Response Body"

                Log.d(
                    "API_RESPONSE", """
                <-- Response ${response.code} (${(endTime - startTime) / 1e6} ms)
                URL: ${request.url}
                Headers: ${response.headers}
                Body: $responseBodyString
            """.trimIndent()
                )

                return@addInterceptor response.newBuilder()
                    .body(ResponseBody.create(responseBody?.contentType(), responseBodyString))
                    .build()
            }

            builder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        builder.connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}