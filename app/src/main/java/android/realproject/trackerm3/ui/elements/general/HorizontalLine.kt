package android.realproject.trackerm3.ui.elements.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalLine() =
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(.5.dp)
            .background(Color(0xB3FFFFFF))
    )