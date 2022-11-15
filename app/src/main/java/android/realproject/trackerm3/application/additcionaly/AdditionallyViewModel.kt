package android.realproject.trackerm3.application.additcionaly

import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.ui.theme.Pink40
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class AdditionallyViewModel (
    private val viewModel: MainViewModel,
    private val navController: NavController
): ViewModel() {

    fun reactPost(likePost: Boolean, index: Int) {
        viewModel.categoryItemData[index].likePost = likePost
    }

    fun likePost( index: Int ): Boolean {
        val isReact = (
                viewModel.categoryItemData[index].likePost != null &&
                viewModel.categoryItemData[index].likePost!!
        )
        if (!isReact) {
            return false
        }
        return true
    }
    fun disLikePost(index: Int): Boolean {
        val isReact = (
                viewModel.categoryItemData[index].likePost != null &&
                !viewModel.categoryItemData[index].likePost!!
        )
        if (!isReact) {
            return false
        }
        return true
    }

}
