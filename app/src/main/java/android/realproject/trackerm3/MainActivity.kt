package android.realproject.trackerm3

import android.content.SharedPreferences
import android.os.Bundle
import android.realproject.trackerm3.utils.KEY_SAVE_EMAIL
import android.realproject.trackerm3.utils.KEY_SAVE_QUOTE_SIZE
import android.realproject.trackerm3.utils.KEY_SAVE_STATE
import android.realproject.trackerm3.utils.KEY_SAVE_TITLE_SIZE
import android.realproject.trackerm3.model.factoryes.ViewModelFactory
import android.realproject.trackerm3.model.navigation.CustomNavGraph
import android.realproject.trackerm3.model.navigation.Screen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import android.realproject.trackerm3.ui.theme.TrackerM3Theme
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    private var pref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrackerM3Theme {
                val navController = rememberNavController()
                val mViewModel: MainViewModel = viewModel(factory = ViewModelFactory(navController, application))
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    pref = getSharedPreferences("LOCAL_DATA", MODE_PRIVATE)

                    val startDest by remember{ mutableStateOf(pref!!.getString(KEY_SAVE_STATE, Screen.OnBoarding1.route)) }
                    if (mViewModel.userEmail.isNotEmpty()) {
                        saveData(mViewModel.userEmail, KEY_SAVE_EMAIL)
                    }
                    if (mViewModel.fontSizeForTitle != 18) {
                        saveData(mViewModel.fontSizeForTitle.toString(), KEY_SAVE_TITLE_SIZE)
                    }
                    if (mViewModel.fontSizeForQuote != 13) {
                        saveData(mViewModel.fontSizeForQuote.toString(), KEY_SAVE_QUOTE_SIZE)
                    }
                    mViewModel.changeUserEmail(pref!!.getString(KEY_SAVE_EMAIL, "1232")!!)
                    mViewModel.changeTextSizeForTitle(pref!!.getString(KEY_SAVE_TITLE_SIZE, "18")!!.toInt())
                    mViewModel.changeTextSizeForQuote(pref!!.getString(KEY_SAVE_QUOTE_SIZE, "13")!!.toInt())
                    CustomNavGraph(navController = navController, mViewModel, startDest!!)

                }
            }
        }
    }

    private fun saveData(content: String, key: String) {
        val edit = pref?.edit()
        edit?.putString(key, content)
        edit?.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData(Screen.CategoryFragmentScreen.route, KEY_SAVE_STATE)
        Log.e("onDestroy", "startDest = ${pref?.getString(KEY_SAVE_STATE, Screen.OnBoarding1.route)} ", )
    }

}

