package ly.com.tahaben.android_tutorials.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import ly.com.tahaben.android_tutorials.domain.SettingsRepository
import ly.com.tahaben.android_tutorials.domain.model.UIMode

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

class SettingsRepositoryImpl(private val ds: DataStore<Preferences>) : SettingsRepository {

    private val uiModeKey = stringPreferencesKey(SettingsRepository.UI_MODE_KEY)
    private val nameKey = stringPreferencesKey(SettingsRepository.NAME_KEY)

    override suspend fun setUiMode(uiMode: UIMode) {
        ds.edit { pref ->
            pref[uiModeKey] = uiMode.name
        }
    }

    override suspend fun getUiModeOnce(): UIMode {
        return UIMode.valueOf(
            ds.data.first()[uiModeKey] ?: UIMode.FOLLOW_SYSTEM.name
        )
    }

    override fun getUiModeAsFlow(): Flow<UIMode> {
        return ds.data.map { prefs ->
            UIMode.valueOf(prefs[uiModeKey] ?: UIMode.FOLLOW_SYSTEM.name)
        }
    }

    override suspend fun setName(name: String) {
        ds.edit { prefs ->
            prefs[nameKey] = name
        }
    }

    override suspend fun getName(): String {
        return ds.data.first()[nameKey] ?: "NO Name"
    }
}