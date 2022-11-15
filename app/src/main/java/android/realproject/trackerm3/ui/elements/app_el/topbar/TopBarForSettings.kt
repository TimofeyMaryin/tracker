package android.realproject.trackerm3.ui.elements.app_el.topbar

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.model.navigation.Screen
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TopBarForSettings(
    viewModel: MainViewModel
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(text = "Настройки")
    }
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
        IconButton(onClick = { viewModel.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }
    }
}