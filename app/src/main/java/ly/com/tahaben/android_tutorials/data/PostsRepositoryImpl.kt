package ly.com.tahaben.android_tutorials.data

import io.ktor.client.call.body
import io.ktor.client.request.get
import ly.com.tahaben.android_tutorials.domain.model.PostItem
import ly.com.tahaben.android_tutorials.domain.repositories.PostsRepository

/* Created by Taha https://github.com/tahaak67/ at 12/9/2024 */

class PostsRepositoryImpl : PostsRepository {
    val client = Client.client
    override suspend fun getAllPosts(): List<PostItem> {
        return try {
            client.get("https://freefakeapi.io/api/posts").body<List<PostItem>>()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}