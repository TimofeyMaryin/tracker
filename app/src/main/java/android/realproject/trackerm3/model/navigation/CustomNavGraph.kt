package android.realproject.trackerm3.model.navigation

import android.app.Application
import android.content.SharedPreferences
import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.model.factoryes.ViewModelFactory
import android.realproject.trackerm3.application.additcionaly.AdditionallyFragment
import android.realproject.trackerm3.application.additcionaly.AdditionallyViewModel
import android.realproject.trackerm3.application.category_fragment.CategoryFragment
import android.realproject.trackerm3.application.settings.SettingsFragment
import android.realproject.trackerm3.model.factoryes.AdditionallyViewModelFactory
import android.realproject.trackerm3.onboarding.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun CustomNavGraph(
    navController: NavHostController,
    mViewModel: MainViewModel,
    startDest: String,
) {

    val addViewModel: AdditionallyViewModel = viewModel(factory = AdditionallyViewModelFactory(mViewModel, navController))
    val onBoardingViewModel: OnBoardingViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = startDest
    ) {
       composable(
           Screen.CategoryFragmentScreen.route
       )  {
           EnterAnimation {
               CategoryFragment(mViewModel = mViewModel, navController)
           }
       }

        composable("${Screen.OnBoardingFragment.route}/{id}") {
            val id = it.arguments?.getString("id", "100")
            AdditionallyFragment(
                content = mViewModel.categoryItemData[id!!.toInt()],
                viewModel = mViewModel,
                addViewModel = addViewModel
            )
        }

        composable(
            Screen.SettingsFragment.route
        ) {
            SettingsFragment(viewModel = mViewModel, addViewModel)
        }

        // OnBoarding
        composable(
            Screen.OnBoarding1.route
        ) {
            EnterAnimation {
                OnBoardingFragment1(viewModel = mViewModel)
            }
        }
        composable(
            Screen.OnBoarding2.route
        ) {
            EnterAnimation {
                OnBoardingFragment2(viewModel = mViewModel)
            }
        }
        composable(
            Screen.OnBoarding3.route
        ) {
            EnterAnimation {
                OnBoardingFragment3(viewModel = mViewModel)
            }
        }
        composable(
            Screen.OnBoarding4.route
        ) {
            EnterAnimation {
                OnBoardingFragment4(viewModel = mViewModel, )
            }
        }
    }
}