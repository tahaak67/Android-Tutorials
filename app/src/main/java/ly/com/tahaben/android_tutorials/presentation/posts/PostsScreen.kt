package ly.com.tahaben.android_tutorials.presentation.posts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* Created by Taha https://github.com/tahaak67/ at 12/9/2024 */

@Composable
fun PostsScreen(
    modifier: Modifier = Modifier,
    state: PostsScreenState,
    onEvent: (PostScreenEvent) -> Unit
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else if (state.postsList.isEmpty()) {
                Button(onClick = {
                    onEvent(PostScreenEvent.RefreshPosts)
                }) {
                    Text("Refresh")
                }
            }
        }
        items(state.postsList) { post ->
            Column(
                Modifier.fillParentMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(post.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text(post.content, fontSize = 16.sp, fontWeight = FontWeight.Normal)
                HorizontalDivider()
            }
        }
    }

}