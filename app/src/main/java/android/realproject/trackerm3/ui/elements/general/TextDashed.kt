package android.realproject.trackerm3.ui.elements.general

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextLayoutResult

@Composable
fun TextDashed(
    text: String
) {
    var layout by remember { mutableStateOf<TextLayoutResult?>(null) }
    Box(
        modifier = Modifier
            .fillMaxHeight() ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            onTextLayout = {
                layout = it
            },
            modifier = Modifier.drawBehind {

                layout?.let {
                    val thickness = 5f
                    val dashPath = 15f
                    val spacingExtra = 4f
                    val offsetY = 6f

                    for (i in 0 until it.lineCount) {
                        drawPath(
                            path = Path().apply {
                                moveTo(it.getLineLeft(i), it.getLineBottom(i) - spacingExtra + offsetY)
                                lineTo(it.getLineRight(i), it.getLineBottom(i) - spacingExtra + offsetY)
                            },
                            Color.Gray,
                            style = Stroke(width = thickness,
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashPath, dashPath), 0f)
                            )
                        )
                    }
                }
            }
        )
    }
}