package android.realproject.trackerm3.ui.elements.on_boarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun InfoVisual(
    icon: Int,
    modifier: Modifier = Modifier,
    tint: Color = Color.White,
    text: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(.5f)
            .background(MaterialTheme.colorScheme.onPrimary)
            .border(BorderStroke(2.dp, Color.White))
            .then(modifier),
        contentAlignment = Alignment.Center,
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = tint
            )
            Text(
                text = stringResource(id = text),
                modifier = Modifier.fillMaxWidth(.6f),
                textAlign = TextAlign.Center,
            )

        }

    }
}