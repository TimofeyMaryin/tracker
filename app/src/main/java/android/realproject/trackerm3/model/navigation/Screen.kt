package android.realproject.trackerm3.model.navigation

sealed class Screen(val route: String) {
    object OnBoardingFragment: Screen(route = "boarding_screen")
    object CategoryFragmentScreen: Screen(route = "category_fragment")
    object SettingsFragment: Screen("settings_fragment")

    object OnBoarding1: Screen("on_borad_1")
    object OnBoarding2: Screen("on_borad_2")
    object OnBoarding3: Screen("on_borad_3")
    object OnBoarding4: Screen("on_borad_4")
}