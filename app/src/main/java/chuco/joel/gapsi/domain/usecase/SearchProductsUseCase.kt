package chuco.joel.gapsi.domain.usecase

import chuco.joel.gapsi.data.remote.dto.toDomainList
import chuco.joel.gapsi.data.repository.ProductRepository
import chuco.joel.gapsi.domain.model.Product
import chuco.joel.gapsi.domain.utils.Constants.PAGE_INITIAL
import chuco.joel.gapsi.data.remote.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(query: String): Flow<Result<List<Product>>> {
        return repository.searchProductByKeyword(query, PAGE_INITIAL)
            .map { result ->
                when (result) {
                    is Result.Success -> Result.Success(result.data.toDomainList())
                    is Result.Error -> Result.Error(result.message, result.code)
                    is Result.Loading -> Result.Loading
                }
            }
    }
}