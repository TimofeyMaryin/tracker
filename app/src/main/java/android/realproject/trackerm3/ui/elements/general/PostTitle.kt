package android.realproject.trackerm3.ui.elements.general

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PostTitle(
    text: String,
    modifier: Modifier = Modifier
) = Text(
    text = text,
    fontSize = 16.sp,
    fontWeight = FontWeight.Light,
    modifier = modifier
)