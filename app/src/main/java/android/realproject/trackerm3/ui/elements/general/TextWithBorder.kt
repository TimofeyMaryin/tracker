package android.realproject.trackerm3.ui.elements.general

import android.graphics.Color.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.unit.dp

@Composable
fun TextWithBorder(
    text: String,
) {
    val textPaintStroke = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.STROKE
        textSize = 120f
        color = WHITE// WHITE
        strokeWidth = 12f
        strokeMiter= 22f
        strokeJoin = android.graphics.Paint.Join.ROUND
    }

    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        style = android.graphics.Paint.Style.FILL
        textSize = 120f
        color = 0xFFF70000.toInt()
    }

    Canvas(
        modifier = Modifier.fillMaxWidth(.5f).fillMaxHeight(.6f),
        onDraw = {
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    text,
                    0f,
                    120.dp.toPx(),
                    textPaintStroke
                )
                it.nativeCanvas.drawText(
                    text,
                    0f,
                    120.dp.toPx(),
                    textPaint
                )
            }
        }
    )
}