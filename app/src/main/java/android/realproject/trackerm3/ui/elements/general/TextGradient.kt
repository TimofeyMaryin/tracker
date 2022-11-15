package android.realproject.trackerm3.ui.elements.general

import android.realproject.trackerm3.ui.theme.red_yellowBG
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


@Composable
fun TextGradient(
    text: String,
    textSize: TextUnit = 18.sp
) {
    Text(
        text = text,
        fontSize = textSize,
        modifier = Modifier.graphicsLayer(alpha = 0.79f)
            .drawWithCache {
                val brush = Brush.horizontalGradient(listOf(
                    Color(0xFF9C4F96),
                    Color(0xFFFF6355),
                    Color(0xFFFBA949),
                    Color(0xFFFAE442),
                    Color(0xFF8BD448),
                    Color(0xFF2AA8F2)
                ))
                onDrawWithContent {
                    drawContent()
                    drawRect(brush, blendMode = BlendMode.SrcAtop)
                }
            },
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
    )
}