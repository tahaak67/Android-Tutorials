package ly.com.tahaben.android_tutorials.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ly.com.tahaben.android_tutorials.domain.repositories.SettingsRepository

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

class DataStoreViewModel(private val repository: SettingsRepository) : ViewModel() {

    var state by mutableStateOf(DataStoreScreenState())
        private set

    init {
        runBlocking {
            state = state.copy(
                darkModeStatus = repository.getUiModeOnce()
            )
        }
        viewModelScope.launch {
            repository.getUiModeAsFlow().collect { uiMode ->
                state = state.copy(
                    darkModeStatus = uiMode
                )
            }
        }
    }


    fun onEvent(event: DataStoreScreenEvent) {
        when (event) {
            is DataStoreScreenEvent.OnNameTextChange -> {
                state = state.copy(
                    userName = event.text
                )
            }

            is DataStoreScreenEvent.OnUiModeChange -> {
                viewModelScope.launch {
                    repository.setUiMode(event.uiMode)
                }
            }

            DataStoreScreenEvent.OnLoadUsername -> {
                viewModelScope.launch {
                    state = state.copy(
                        userName = repository.getName()
                    )
                }
            }

            DataStoreScreenEvent.OnSaveUsername -> {
                viewModelScope.launch {
                    repository.setName(state.userName)
                }
            }
        }
    }
}