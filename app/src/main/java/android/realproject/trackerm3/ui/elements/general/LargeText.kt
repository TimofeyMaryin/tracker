package android.realproject.trackerm3.ui.elements.general

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.White
) = Text(
    text = text,
    fontSize = 28.sp,
    color = textColor,
    modifier = modifier,
    fontWeight = FontWeight.ExtraBold
)