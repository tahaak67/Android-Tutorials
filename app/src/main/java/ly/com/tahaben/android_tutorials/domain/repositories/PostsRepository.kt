package ly.com.tahaben.android_tutorials.domain.repositories

import ly.com.tahaben.android_tutorials.domain.model.PostItem

/* Created by Taha https://github.com/tahaak67/ at 12/9/2024 */

interface PostsRepository {

    suspend fun getAllPosts(): List<PostItem>
}