package android.realproject.trackerm3.onboarding

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.model.navigation.Screen
import android.realproject.trackerm3.ui.elements.on_boarding.ButtonElement
import android.realproject.trackerm3.ui.elements.on_boarding.InfoVisual
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun OnBoardingFragment2(
    viewModel: MainViewModel,
) {
    OnBoardingContent(
        imageUri = R.drawable.onboarding_2,
        title = "Светлой темы нет!!!",
        postTitle = "Даже, если есть кнопка, тут заботяться о твоем  зрении",
        countActivePage = 1
    ) {
        viewModel.navigate(Screen.OnBoarding3.route)
    }
}