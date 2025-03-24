package chuco.joel.gapsi.di

import chuco.joel.gapsi.data.repository.ProductRepository
import chuco.joel.gapsi.domain.usecase.SearchProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideSearchProductUseCase(
        repository: ProductRepository
    ): SearchProductUseCase {
        return SearchProductUseCase(repository)
    }
}