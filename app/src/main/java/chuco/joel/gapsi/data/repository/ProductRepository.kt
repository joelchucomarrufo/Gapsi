package chuco.joel.gapsi.data.repository

import chuco.joel.gapsi.data.remote.dto.ProductResponseDto
import chuco.joel.gapsi.data.remote.utils.Result
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun searchProductByKeyword(query: String, page: Int) : Flow<Result<ProductResponseDto>>

}