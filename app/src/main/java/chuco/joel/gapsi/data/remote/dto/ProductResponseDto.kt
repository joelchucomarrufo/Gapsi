package chuco.joel.gapsi.data.remote.dto

import com.google.gson.annotations.SerializedName

class ProductResponseDto : BaseResponse<ItemDto>()

data class ItemDto(
    @SerializedName("props") val props: PropsDto,
)

data class PropsDto(
    @SerializedName("pageProps") val pageProps: PagePropsDto,
)

data class PagePropsDto(
    @SerializedName("initialData") val initialData: InitialDataDto,
)

data class InitialDataDto(
    @SerializedName("searchResult") val searchResult: SearchResultDto,
)

data class SearchResultDto(
    @SerializedName("itemStacks") val itemStacks: ArrayList<ItemStackDto>,
)

data class ItemStackDto(
    @SerializedName("items") val items: ArrayList<ProductDto>,
)
