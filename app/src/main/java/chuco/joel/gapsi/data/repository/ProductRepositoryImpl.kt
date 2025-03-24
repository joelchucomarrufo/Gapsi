package chuco.joel.gapsi.data.repository

import chuco.joel.gapsi.data.remote.ApiService
import chuco.joel.gapsi.data.remote.dto.ProductResponseDto
import chuco.joel.gapsi.data.remote.utils.Constants.SORT_BEST_MATCH
import chuco.joel.gapsi.data.remote.utils.NetworkBoundResource
import chuco.joel.gapsi.data.remote.utils.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val networkBoundResources: NetworkBoundResource,
) : ProductRepository {

    override suspend fun searchProductByKeyword(query: String, page: Int): Flow<Result<ProductResponseDto>> {
        return networkBoundResources.callService { apiService.searchProductByKeyword(
            query = query,
            page = page,
            sortBy = SORT_BEST_MATCH
        ) }
    }

}