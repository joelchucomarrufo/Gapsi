package chuco.joel.gapsi.di

import chuco.joel.gapsi.data.repository.ProductRepository
import chuco.joel.gapsi.data.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun bindProductRepository(productRepository: ProductRepositoryImpl): ProductRepository

}