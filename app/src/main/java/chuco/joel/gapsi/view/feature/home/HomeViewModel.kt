package chuco.joel.gapsi.view.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chuco.joel.gapsi.domain.model.Product
import chuco.joel.gapsi.domain.usecase.SearchProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import chuco.joel.gapsi.data.remote.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productUseCases: SearchProductUseCase
) : ViewModel() {

    var query by mutableStateOf("")
    private val _products = MutableStateFlow<Result<List<Product>>?>(null)
    val products: StateFlow<Result<List<Product>>?> = _products

    fun searchProducts() {
        viewModelScope.launch {
            _products.value = Result.Loading
            val flow = productUseCases.invoke(query)
            flow.collect { result ->
                _products.value = result
            }
        }
    }
}