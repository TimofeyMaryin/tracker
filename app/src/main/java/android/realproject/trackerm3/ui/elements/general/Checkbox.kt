package android.realproject.trackerm3.ui.elements.general

import android.realproject.trackerm3.ui.theme.*
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Checkbox(
    checked: Boolean,
) {
    val startPos = 0.dp
    val endPos = 28.dp
    val isEnabled by animateDpAsState(targetValue = if (checked) endPos else startPos)
    val isEnabledColorBg by animateColorAsState(targetValue = if (checked) DarkBlue else Color.DarkGray)
    val isEnabledColorSlider by animateColorAsState(targetValue = if (checked) LightBlue else Color.White)

    Box(
        modifier = Modifier
            .width(50.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
                .clip(CircleShape)
                .background(isEnabledColorBg),
        )
        Box(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth()
                .padding(start = isEnabled),
            contentAlignment = Alignment.CenterStart)
        {
            Slider(color = isEnabledColorSlider)
        }

    }
}

@Composable
private fun Slider(
    color: Color
) =
    Box(
        modifier = Modifier
            .size(25.dp)
            .clip(CircleShape)
            .background(color)
    )
