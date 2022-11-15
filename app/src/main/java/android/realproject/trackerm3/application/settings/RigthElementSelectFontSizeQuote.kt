package android.realproject.trackerm3.application.settings

import android.realproject.trackerm3.utils.OPEN_QUOTE_ALERT
import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.ui.elements.general.TextDashed
import android.realproject.trackerm3.utils.DEFAULT_TITLE_TEXT_SIZE
import android.realproject.trackerm3.utils.REFRESH_QUOTE_SIZE
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun RigthElementSelectFontSizeQuote(
    viewModel: MainViewModel
) {
    TextDashed(text = viewModel.fontSizeForQuote.toString())
    CustomAlertDialog(
        viewModel = viewModel,
        valueTextField = viewModel.fontSizeForQuote.toString(),
        onChangeTextField = {
            if (it.isEmpty()) {
                viewModel.changeTextSizeForQuote(0)
            } else {
                if (it.length <= 2) {
                    viewModel.changeTextSizeForQuote(it.toInt())
                }
            }
        },
        title = "Возьми чуть меньше, чем брал пжпжпжп",
        keyboardType = KeyboardType.Number,
        type = OPEN_QUOTE_ALERT,
        validateDate = {
            viewModel.validateQuote()
        },

    )
}