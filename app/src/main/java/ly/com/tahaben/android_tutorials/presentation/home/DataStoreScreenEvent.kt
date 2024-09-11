package ly.com.tahaben.android_tutorials.presentation.home

import ly.com.tahaben.android_tutorials.domain.model.UIMode

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

sealed class DataStoreScreenEvent {
    data class OnNameTextChange(val text: String) : DataStoreScreenEvent()
    data class OnUiModeChange(val uiMode: UIMode) : DataStoreScreenEvent()
    object OnSaveUsername : DataStoreScreenEvent()
    object OnLoadUsername : DataStoreScreenEvent()
}