package ly.com.tahaben.android_tutorials.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostItem(
    @SerialName("content")
    val content: String,
    @SerialName("id")
    val id: Int,
    @SerialName("_links")
    val links: Links,
    @SerialName("picture")
    val picture: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("title")
    val title: String,
    @SerialName("user")
    val user: String
)