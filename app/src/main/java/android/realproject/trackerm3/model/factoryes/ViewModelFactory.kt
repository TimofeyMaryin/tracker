package android.realproject.trackerm3.model.factoryes

import android.app.Application
import android.realproject.trackerm3.MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val navController: NavController,
    private val application: Application
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(navController, application) as T
    }
}