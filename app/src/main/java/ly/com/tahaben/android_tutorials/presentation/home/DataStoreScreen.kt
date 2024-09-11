package ly.com.tahaben.android_tutorials.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GetApp
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ly.com.tahaben.android_tutorials.domain.model.UIMode
import ly.com.tahaben.android_tutorials.presentation.theme.AndroidTutorialsTheme

/* Created by Taha https://github.com/tahaak67/ at 11/9/2024 */

@Composable
fun DataStoreExampleScreen(
    modifier: Modifier = Modifier,
    state: DataStoreScreenState,
    onEvent: (DataStoreScreenEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        UIMode.entries.forEach { uiMode ->
            RadioRow(
                text = uiMode.getDisplayName(),
                isChecked = state.darkModeStatus == uiMode,
                onClick = {
                    onEvent(DataStoreScreenEvent.OnUiModeChange(uiMode))
                }
            )
        }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.userName,
            onValueChange = { onEvent(DataStoreScreenEvent.OnNameTextChange(it)) },
            label = { Text("Username") }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            Button(onClick = {
                onEvent(DataStoreScreenEvent.OnSaveUsername)
            }) {
                Icon(Icons.Rounded.Save, contentDescription = null)
                Text("Save Username")
            }
            Button(onClick = {
                onEvent(DataStoreScreenEvent.OnLoadUsername)
            }) {
                Icon(Icons.Rounded.GetApp, contentDescription = null)
                Text("Load Username", fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
private fun DataStoreExampleScreenPreview() {
    AndroidTutorialsTheme {
        DataStoreExampleScreen(state = DataStoreScreenState(), onEvent = {})
    }
}

@Composable
fun RadioRow(
    modifier: Modifier = Modifier,
    text: String,
    isChecked: Boolean,
    onClick: () -> Unit,
    arrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
) {
    Row(
        modifier
            .fillMaxWidth()
            .selectable(
                selected = isChecked,
                role = Role.RadioButton,
                onClick = onClick
            ),
        horizontalArrangement = arrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text)
        RadioButton(selected = isChecked, onClick = onClick)
    }
}