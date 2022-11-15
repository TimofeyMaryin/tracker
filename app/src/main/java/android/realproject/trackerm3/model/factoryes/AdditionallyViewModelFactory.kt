package android.realproject.trackerm3.model.factoryes

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.application.additcionaly.AdditionallyViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

@Suppress("UNCHECKED_CAST")
class AdditionallyViewModelFactory(
    private val viewModel: MainViewModel,
    private val navController: NavController
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AdditionallyViewModel(viewModel = viewModel, navController = navController) as T
    }
}