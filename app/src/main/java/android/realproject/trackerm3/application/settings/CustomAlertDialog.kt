package android.realproject.trackerm3.application.settings

import android.realproject.trackerm3.utils.OPEN_EMAIL_ALERT
import android.realproject.trackerm3.utils.OPEN_QUOTE_ALERT
import android.realproject.trackerm3.utils.OPEN_TITLE_ALERT
import android.realproject.trackerm3.MainViewModel
import android.realproject.trackerm3.R
import android.realproject.trackerm3.ui.theme.red_yellowBG
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomAlertDialog(
    viewModel: MainViewModel,
    valueTextField: String,
    onChangeTextField: (String) -> Unit,
    title: String,
    enabled: Boolean = true,
    keyboardType: KeyboardType,
    type: Int,
    validateDate: () -> Unit,
) {
    if (
        when(type) {
            OPEN_EMAIL_ALERT -> viewModel.alertForEmail
            OPEN_TITLE_ALERT -> viewModel.alertForTitle
            OPEN_QUOTE_ALERT -> viewModel.alertForQuote
            else -> false
        }
    ) {
        AlertDialog(
            onDismissRequest = { viewModel.openAlertWindow(type) },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.openAlertWindow(type)
                        validateDate()
                    },
                    enabled = enabled,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Сохранить")
                }
            },
            title = {
                    Text(text = title)
            },
            text = {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextField(
                        value = valueTextField,
                        onChangeValue = { onChangeTextField(it) },
                        keyboardType = keyboardType
                    )

                }

            }

        )
    }
}


@Composable
private fun TextField(
    value: String,
    onChangeValue: (String) -> Unit,
    keyboardType: KeyboardType
) {
    BasicTextField(
        value = value,
        onValueChange = {
            onChangeValue(it)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        maxLines = 1,
        singleLine = true,
        cursorBrush = Brush.verticalGradient(red_yellowBG),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = FontFamily.Monospace
        ),
        modifier = Modifier.padding(vertical = 20.dp),
    )
}