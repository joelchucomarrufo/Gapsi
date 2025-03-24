package chuco.joel.gapsi.data.remote

import chuco.joel.gapsi.data.remote.dto.ProductResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/wlm/walmart-search-by-keyword")
    suspend fun searchProductByKeyword(
        @Query("keyword") query: String,
        @Query("page") page: Int,
        @Query("sortBy") sortBy: String
    ) : Response<ProductResponseDto>

}