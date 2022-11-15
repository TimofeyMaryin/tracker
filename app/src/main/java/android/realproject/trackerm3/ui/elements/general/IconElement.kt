package android.realproject.trackerm3.ui.elements.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


@Composable
fun IconElement(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick:() -> Unit,
    tint: Color = Color.White,
    roundedCornerShape: RoundedCornerShape
) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(50.dp)
            .clip(roundedCornerShape)
            .background(Color.LightGray)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { onClick() }) {
            Icon(painter = painterResource(id = icon), contentDescription = null, tint = tint)
        }
    }
}