package ly.com.tahaben.android_tutorials.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Delete(
    @SerialName("href")
    val href: String
)