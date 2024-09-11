package ly.com.tahaben.android_tutorials.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.viewmodel.compose.viewModel
import ly.com.tahaben.android_tutorials.data.SettingsRepositoryImpl
import ly.com.tahaben.android_tutorials.domain.model.UIMode
import ly.com.tahaben.android_tutorials.presentation.home.DataStoreExampleScreen
import ly.com.tahaben.android_tutorials.presentation.home.DataStoreViewModel
import ly.com.tahaben.android_tutorials.presentation.theme.AndroidTutorialsTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val MAIN_APP_SETTING = "app_settings"
        lateinit var dataStore: DataStore<Preferences>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStore = PreferenceDataStoreFactory.create(
            produceFile = { applicationContext.preferencesDataStoreFile(MAIN_APP_SETTING) }
        )
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<DataStoreViewModel>() {
                DataStoreViewModel(
                    SettingsRepositoryImpl(
                        dataStore
                    )
                )
            }
            val uiMode = viewModel.state.darkModeStatus
            val isDark = when (uiMode) {
                UIMode.LIGHT -> false
                UIMode.DARK -> true
                UIMode.FOLLOW_SYSTEM -> isSystemInDarkTheme()
            }
            AndroidTutorialsTheme(darkTheme = isDark) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DataStoreExampleScreen(
                        Modifier.padding(innerPadding),
                        state = viewModel.state,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }
    }
}
