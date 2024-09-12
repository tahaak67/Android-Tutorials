package ly.com.tahaben.android_tutorials.presentation.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ly.com.tahaben.android_tutorials.domain.repositories.PostsRepository

/* Created by Taha https://github.com/tahaak67/ at 12/9/2024 */

class PostsViewModel(
    private val repository: PostsRepository
) : ViewModel() {

    var state by mutableStateOf(PostsScreenState())
        private set

    init {
        getAllPosts()
    }


    fun onEvent(event: PostScreenEvent) {
        when (event) {
            PostScreenEvent.RefreshPosts -> {
                getAllPosts()
            }
        }
    }

    private fun getAllPosts() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            state = state.copy(
                postsList = repository.getAllPosts()
            )
            state = state.copy(isLoading = false)
        }
    }
}