package chuco.joel.gapsi.view.feature.home

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chuco.joel.gapsi.data.local.SearchHistoryManager
import chuco.joel.gapsi.domain.model.Product
import chuco.joel.gapsi.domain.usecase.SearchProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import chuco.joel.gapsi.data.remote.utils.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val productUseCases: SearchProductUseCase
) : ViewModel() {

    private val _products = MutableStateFlow<Result<List<Product>>?>(null)
    val products: StateFlow<Result<List<Product>>?> = _products

    private val _history = MutableStateFlow<List<String>>(emptyList())
    val history: StateFlow<List<String>> = _history

    private val _query = MutableStateFlow("")
    private val query: StateFlow<String> = _query

    init {
        loadHistory()
    }

    fun updateQuery(value: String) {
        _query.value = value
    }

    fun searchProducts() {
        viewModelScope.launch {
            SearchHistoryManager.saveQuery(context, query.value)
            loadHistory()
            _products.value = Result.Loading
            val flow = productUseCases.invoke(query.value)
            flow.collect { result ->
                _products.value = result
            }
        }
    }

    private fun loadHistory() {
        viewModelScope.launch {
            _history.value = SearchHistoryManager.getHistory(context)
        }
    }
}