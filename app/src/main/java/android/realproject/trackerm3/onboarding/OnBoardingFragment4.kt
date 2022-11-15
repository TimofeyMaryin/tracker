package android.realproject.trackerm3.onboarding

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.model.navigation.Screen
import android.realproject.trackerm3.ui.elements.on_boarding.ButtonElement
import android.realproject.trackerm3.ui.elements.on_boarding.InfoVisual
import android.realproject.trackerm3.ui.theme.hotPink_cyan
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController

@Composable
fun OnBoardingFragment4(
    viewModel: MainViewModel,
) {
    OnBoardingContent(
        imageUri = R.drawable.onboarding_4,
        title = "Ну в общем если до сюда ты дошел, то по... ",
        postTitle = "присоединяйся, лол, что ждешь то....",
        countActivePage = 3
    ) {
        viewModel.navigate(
            endRoute = Screen.CategoryFragmentScreen.route,
            startRoute = Screen.OnBoarding1.route
        )
    }
}