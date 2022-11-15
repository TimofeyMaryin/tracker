package android.realproject.trackerm3.ui.elements.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Counter(
    countActivePage: Int,
    modifier: Modifier,
) {
    val isActive = mutableListOf(false)
    for(i in 0 until 4) {
        isActive.add(i, countActivePage == i)
    }

    Row(
        modifier = Modifier
            .defaultMinSize(minHeight = 50.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(30.dp), contentAlignment = Alignment.Center) {
            CounterElement(
                isActive[0],
            )
        }

        Box(modifier = Modifier.width(30.dp), contentAlignment = Alignment.Center) {
            CounterElement(
                isActive[1],
            )
        }
        Box(modifier = Modifier.width(30.dp), contentAlignment = Alignment.Center) {
            CounterElement(
                isActive[2],
            )
        }
        Box(modifier = Modifier.width(30.dp), contentAlignment = Alignment.Center) {
            CounterElement(
                isActive[3],
            )
        }
    }
}

@Composable
private fun CounterElement(isActive: Boolean = false) =
    Box(modifier = Modifier
        .size(10.dp)
        .clip(CircleShape)
        .background(if (isActive) MaterialTheme.colorScheme.error else Color.White)
    )