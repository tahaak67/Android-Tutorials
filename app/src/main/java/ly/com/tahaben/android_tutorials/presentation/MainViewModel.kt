package ly.com.tahaben.android_tutorials.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/* Created by Taha https://github.com/tahaak67/ at 12/9/2024 */

class MainViewModel : ViewModel() {

    var x by mutableStateOf(0)
        private set


    fun increaseCount() {
        x++
    }
}