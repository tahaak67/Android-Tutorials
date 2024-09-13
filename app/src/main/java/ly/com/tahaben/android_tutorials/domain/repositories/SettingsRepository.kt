package ly.com.tahaben.android_tutorials.domain.repositories

import kotlinx.coroutines.flow.Flow
import ly.com.tahaben.android_tutorials.domain.model.UIMode

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

interface SettingsRepository {

    companion object {
        const val UI_MODE_KEY = "ui_mode_key"
        const val NAME_KEY = "name_key"
    }

    suspend fun setUiMode(uiMode: UIMode)

    suspend fun getUiModeOnce(): UIMode

    fun getUiModeAsFlow(): Flow<UIMode>

    suspend fun setName(name: String)

    suspend fun getName(): String
}