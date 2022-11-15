package android.realproject.trackerm3.onboarding

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.model.navigation.Screen
import android.realproject.trackerm3.ui.elements.on_boarding.ButtonElement
import android.realproject.trackerm3.ui.elements.on_boarding.Counter
import android.realproject.trackerm3.ui.elements.on_boarding.TextContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun OnBoardingContent(
    imageUri: Int,
    title: String,
    postTitle: String,
    countActivePage: Int,
    onClick:() -> Unit
){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (iconEl, textEl, counterEl, buttonEL) = createRefs()
        Image(
            painter = painterResource(id = imageUri),
            contentDescription = null,
            modifier = Modifier.constrainAs(iconEl) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 250.dp)
            }
        )
        TextContent(
            title = title,
            postTitle = postTitle,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .constrainAs(textEl){
                    top.linkTo(iconEl.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(counterEl.top)
            }
        )
        Counter(
            countActivePage = countActivePage,
            modifier = Modifier.constrainAs(counterEl) {
                top.linkTo(textEl.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(buttonEL.top)
            }
        )
        ButtonElement(
            onClickNext = { onClick() },
            modifier = Modifier.constrainAs(buttonEL) {
                top.linkTo(counterEl.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}