package chuco.joel.gapsi.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductResponseDto(
    @SerializedName("results")
    val results: List<ProductDto>
)