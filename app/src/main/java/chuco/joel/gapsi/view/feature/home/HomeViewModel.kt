package chuco.joel.gapsi.view.feature.home

import androidx.lifecycle.ViewModel
import chuco.joel.gapsi.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    
}