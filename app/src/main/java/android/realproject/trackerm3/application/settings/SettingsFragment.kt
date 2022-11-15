package android.realproject.trackerm3.application.settings

import android.app.Activity
import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.application.additcionaly.AdditionallyViewModel
import android.realproject.trackerm3.ui.elements.app_el.topbar.CustomTopBar
import android.realproject.trackerm3.ui.elements.app_el.topbar.TopBarForSettings
import android.realproject.trackerm3.ui.elements.general.Checkbox
import android.realproject.trackerm3.ui.elements.general.HorizontalLine
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsFragment(
    viewModel: MainViewModel,
    additionallyViewModel: AdditionallyViewModel
) {
    val activity = (LocalContext.current as? Activity)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 CustomTopBar(height = 80.dp) {
                     TopBarForSettings(viewModel = viewModel)
                 }
        },
    ) {
        LazyColumn {
            items(viewModel.settingsContent.size) {
                SettingsItem(
                    viewModel = viewModel,
                    key = it,
                    rightElement = {
                        when (it) {
                            2 -> {
                                RightElementTextField(viewModel = viewModel)
                            }
                            3 -> {
                                Checkbox(checked = viewModel.isWhiteTheme)
                            }
                            4 -> {
                                RigthElementSelectFontSize(viewModel = viewModel)
                            }
                            5 -> {
                                RigthElementSelectFontSizeQuote(viewModel = viewModel)
                            }
                        }
                    },
                    index = it
                )
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(minHeight = 70.dp)
                            .clickable { activity?.finish() },
                        contentAlignment = Alignment.CenterStart)
                    {
                        Text(
                            text = "Выйти",
                            color = MaterialTheme.colorScheme.errorContainer,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        //TODO()
                    }
                }

            }
        }
    }
}