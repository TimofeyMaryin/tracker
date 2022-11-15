package android.realproject.trackerm3.onboarding

import android.realproject.trackerm3.model.navigation.Screen
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class OnBoardingViewModel: ViewModel() {
    fun navigate(navController: NavController, route: String) = navController.navigate(route)
    fun popBackStack(navController: NavController) = navController.popBackStack()

}