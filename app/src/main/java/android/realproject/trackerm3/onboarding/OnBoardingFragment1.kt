package android.realproject.trackerm3.onboarding

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.model.navigation.Screen
import android.realproject.trackerm3.ui.elements.on_boarding.ButtonElement
import android.realproject.trackerm3.ui.elements.on_boarding.Counter
import android.realproject.trackerm3.ui.elements.on_boarding.InfoVisual
import android.realproject.trackerm3.ui.elements.on_boarding.TextContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingFragment1(
    viewModel: MainViewModel,
) {
    OnBoardingContent(
        imageUri = R.drawable.onboarding_img,
        title = "Доброе пожаловать в Tracker",
        postTitle = "Лучшее место для тебя",
        countActivePage = 0
    ) {
        viewModel.navigate(Screen.OnBoarding2.route)
    }

}


