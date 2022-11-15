package android.realproject.trackerm3.application.additcionaly

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.ui.elements.general.IconElement
import android.realproject.trackerm3.ui.theme.red_yellowBG
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ReactionFragment(
    viewModel: AdditionallyViewModel,
    mViewModel: MainViewModel,
    index: Int
) {
    //val brush = Brush.horizontalGradient(red_yellowBG)
    var likePost by remember{ mutableStateOf(viewModel.likePost(index)) }
    var isOpen by remember{ mutableStateOf(false) }
    var disLikePost by remember { mutableStateOf(viewModel.disLikePost(index)) }

    // условие хуйня ненужная,
    // но убирать это впадлу!
    if (mViewModel.userInformedAboutReact) {

        if (isOpen) {
            AlertDialog(
                onDismissRequest = {isOpen = false },
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_hand),
                            contentDescription = null,
                        )
                        Text(text = "Это, тут всем пофЕГ")
                        Icon(
                            painter = painterResource(id = R.drawable.ic_hand),
                            contentDescription = null
                        )
                    }
                },
                text = {
                    Text(
                        text = "Разрабу было влом что-то делать",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                confirmButton = {
                    Button(
                        onClick = { isOpen = false },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(text = "Понятно")
                    }
                }
            )
        }
    }
    Box(
        modifier = Modifier
            .defaultMinSize(minHeight = 100.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(minWidth = 200.dp)
                .padding(start = 40.dp)
        ) {
            IconElement(
                icon = R.drawable.ic_thumb_up_alt,
                onClick = {
                    if (disLikePost) {
                        disLikePost = false
                    }
                    viewModel.reactPost(true, index)
                    likePost = !likePost
                    isOpen = true
                    mViewModel.informUserAboutReact()

                },
                roundedCornerShape = RoundedCornerShape(topStart = 35.dp, bottomStart = 35.dp),
                tint = if (likePost) Color.Red else Color.White
            )
            IconElement(
                icon = R.drawable.ic_thumb_down_alt,
                onClick = {
                    if (likePost) {
                        likePost = false
                    }
                    viewModel.reactPost(false, index)
                    disLikePost = !disLikePost
                    isOpen = true
                    mViewModel.informUserAboutReact()
                },
                roundedCornerShape = RoundedCornerShape(
                    topEnd = 35.dp,
                    bottomEnd = 35.dp
                ),
                tint = if (disLikePost) Color.Red else Color.White
                )

        }
    }


}