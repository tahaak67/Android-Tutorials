package ly.com.tahaben.android_tutorials.presentation.home

import ly.com.tahaben.android_tutorials.domain.model.UIMode

data class DataStoreScreenState(
    val darkModeStatus: UIMode = UIMode.FOLLOW_SYSTEM,
    val userName: String = ""
)