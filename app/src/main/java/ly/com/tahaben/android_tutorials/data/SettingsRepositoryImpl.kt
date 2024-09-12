package ly.com.tahaben.android_tutorials.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import ly.com.tahaben.android_tutorials.domain.model.UIMode
import ly.com.tahaben.android_tutorials.domain.repositories.SettingsRepository

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

class SettingsRepositoryImpl(private val ds: DataStore<Preferences>) : SettingsRepository {

    override suspend fun setUiMode(uiMode: UIMode) {
        ds.edit { pref ->
            pref[SettingsRepository.UI_MODE_KEY] = uiMode.name
        }
    }

    override suspend fun getUiModeOnce(): UIMode {
        return UIMode.valueOf(
            ds.data.first()[SettingsRepository.UI_MODE_KEY] ?: UIMode.FOLLOW_SYSTEM.name
        )
    }

    override fun getUiModeAsFlow(): Flow<UIMode> {
        return ds.data.map { prefs ->
            UIMode.valueOf(prefs[SettingsRepository.UI_MODE_KEY] ?: UIMode.FOLLOW_SYSTEM.name)
        }
    }

    override suspend fun setName(name: String) {
        ds.edit { prefs ->
            prefs[SettingsRepository.NAME_KEY] = name
        }
    }

    override suspend fun getName(): String {
        return ds.data.first()[SettingsRepository.NAME_KEY] ?: "NO Name"
    }
}