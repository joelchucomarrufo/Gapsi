package chuco.joel.gapsi.data.remote.dto

import chuco.joel.gapsi.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: Double?,
    @SerializedName("imageInfo") val imageInfo: ProductImageInfoDto?,
)

data class ProductImageInfoDto(
    @SerializedName("thumbnailUrl") val thumbnailUrl: String,
)

fun ProductDto.toDomain(): Product {
    return Product(
        id = id ?: "",
        title = name ?: "",
        price = price ?: 0.0,
        thumbnail = imageInfo?.thumbnailUrl ?: ""
    )
}