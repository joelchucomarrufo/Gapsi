package chuco.joel.gapsi.data.remote.dto

import com.google.gson.annotations.SerializedName

open class BaseResponse<L> {
    @SerializedName("responseStatus") var responseStatus: String = ""
    @SerializedName("item") var item: L? = null
}