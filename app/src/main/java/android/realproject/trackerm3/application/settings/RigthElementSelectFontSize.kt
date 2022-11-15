package android.realproject.trackerm3.application.settings

import android.realproject.trackerm3.utils.OPEN_TITLE_ALERT
import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.ui.elements.general.TextDashed
import android.realproject.trackerm3.utils.DEFAULT_QUOTE_TEXT_SIZE
import android.realproject.trackerm3.utils.REFRESH_TITLE_SIZE
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun RigthElementSelectFontSize(
    viewModel: MainViewModel
) {
    TextDashed(text = viewModel.fontSizeForTitle.toString())
    CustomAlertDialog(
        viewModel = viewModel,
        valueTextField = viewModel.fontSizeForTitle.toString(),
        onChangeTextField = {
            if (it.isEmpty()) {
                viewModel.changeTextSizeForTitle(0)
            } else {
                if (it.length <= 2) {
                    viewModel.changeTextSizeForTitle(it.toInt())
                }
            }
        },
        title = "Ну давай, только в рамках нормы, ок?",
        keyboardType = KeyboardType.Number,
        type = OPEN_TITLE_ALERT,
        validateDate = {
            viewModel.validateTitle()
        },

    )
}