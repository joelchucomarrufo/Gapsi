package chuco.joel.gapsi.data.remote.dto

import chuco.joel.gapsi.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Double,
    @SerializedName("thumbnail") val thumbnail: String
)

fun ProductDto.toDomain(): Product {
    return Product(
        title = title,
        price = price,
        thumbnail = thumbnail
    )
}