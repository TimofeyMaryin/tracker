package android.realproject.trackerm3.application.settings

import android.realproject.trackerm3.utils.OPEN_EMAIL_ALERT
import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.ui.elements.general.TextDashed
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun RightElementTextField(
    viewModel: MainViewModel
) {

    TextDashed(text = viewModel.userEmail)
    CustomAlertDialog(
        viewModel = viewModel,
        valueTextField = viewModel.userEmail,
        onChangeTextField = {
            viewModel.changeUserEmail(it)
            viewModel.validateEmail()
        },
        title = viewModel.validateEmailText(),
        enabled = viewModel.validateEmailVariable,
        keyboardType = KeyboardType.Email,
        OPEN_EMAIL_ALERT,

        validateDate = {},

    )

}