package ly.com.tahaben.android_tutorials.presentation.posts

import ly.com.tahaben.android_tutorials.domain.model.PostItem

data class PostsScreenState(
    val isLoading: Boolean = true,
    val postsList: List<PostItem> = emptyList()
)
