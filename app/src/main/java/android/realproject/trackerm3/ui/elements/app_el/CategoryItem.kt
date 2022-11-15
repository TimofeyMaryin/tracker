package android.realproject.trackerm3.ui.elements.app_el

import android.realproject.trackerm3.R
import android.realproject.trackerm3.model.CategoryItemData
import android.realproject.trackerm3.ui.elements.general.TitleText
import android.realproject.trackerm3.ui.theme.Purple40
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    content: CategoryItemData,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5))
            .fillMaxWidth(.9f)
            .fillMaxHeight()
            .then(modifier),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            if (content.imageBg != null) {
                Image(
                    painter = painterResource(id = content.imageBg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }else {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            }
        }
        Box(modifier = Modifier.fillMaxSize().alpha(.5f).background(brush = content.bgColor))
        Box(contentAlignment = Alignment.CenterStart) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 13.dp, top = 20.dp, bottom = 20.dp)
            ) {
                Box(
                    modifier = Modifier.weight(.5f),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Icon(
                        painter = painterResource(id = content.icon),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    TitleText(text = content.text)
                }

            }
        }


    }
}