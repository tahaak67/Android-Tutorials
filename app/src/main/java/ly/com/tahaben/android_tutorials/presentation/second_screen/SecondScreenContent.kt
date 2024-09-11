package ly.com.tahaben.android_tutorials.presentation.second_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */


@Composable
fun SecondScreenContent(modifier: Modifier = Modifier, name: String, onBackClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        Text("Second Screen!", fontSize = 25.sp)
        Text("The name is $name", fontSize = 25.sp)
        Button(onClick = onBackClick) {
            Text("Go back")
        }
    }
}


@Preview
@Composable
private fun SecondScreenPreview() {
    SecondScreenContent(name = "TahaBen", onBackClick = {})
}