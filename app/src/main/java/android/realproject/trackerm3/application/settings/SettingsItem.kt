package android.realproject.trackerm3.application.settings

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.ui.elements.general.HorizontalLine
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SettingsItem(
    viewModel: MainViewModel,
    key: Int,
    textColor: Color = Color.White,
    rightElement: @Composable () -> Unit = { },
    index: Int
) {
    val contentSetting = viewModel.settingsContent[key]!!
    val iconSettingsItem = listOf(
        R.drawable.ic_setting_item_learn,
        R.drawable.ic_setting_item_refresh,
        R.drawable.ic_setting_item_email,
        R.drawable.ic_fill_content,
        R.drawable.ic_text,
        R.drawable.ic_text
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .defaultMinSize(minHeight = 70.dp)
            .clickable(onClick = contentSetting.second) ,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    painter = painterResource(id = iconSettingsItem[index]),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = contentSetting.first,
                    color = textColor,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            rightElement()
        }
    }
}


