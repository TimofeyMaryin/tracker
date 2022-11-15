package android.realproject.trackerm3

import android.app.Application
import android.realproject.trackerm3.model.CategoryItemData
import android.realproject.trackerm3.model.navigation.Screen
import android.realproject.trackerm3.ui.theme.*
import android.realproject.trackerm3.utils.*
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class MainViewModel (
    private val navController: NavController,
    private val application: Application
): ViewModel() {


    val categoryItemData = mutableListOf(
        CategoryItemData(
            id = 0,
            R.drawable.icon_post_1,
            "Почему стоит быть пожарным",
            Brush.verticalGradient(whaleHouse),
            imageBg = R.drawable.fireman_art,
            descToAddiction = R.string.fireman_text,
            quote = R.string.quote_fireman
        ),
        CategoryItemData(
            id = 1,
            R.drawable.icon_post_3,
            "Вино: полезно или вредно",
            Brush.horizontalGradient(whaleHouse),
            imageBg = R.drawable.wine_art,
            descToAddiction = R.string.wine_text,
            quote = R.string.quote_wine
        ),
        CategoryItemData(
            id = 2,
            icon = R.drawable.icon_post_4,
            text = "Почему тебе стоит заняться спортом",
            bgColor = Brush.horizontalGradient(whaleHouse),
            imageBg = R.drawable.olimpyc_games,
            descToAddiction = R.string.sport_text,
            quote = R.string.quote_sport
        ),
        CategoryItemData(
            id = 3,
            R.drawable.icon_post_2,
            "Что о тебе говорит твоя самооценка",
            Brush.horizontalGradient(whaleHouse),
            imageBg = R.drawable.abstractperson_art,
            descToAddiction = R.string.self_esteem_text,
            quote = R.string.quote_self_esteem
        ),
        CategoryItemData(
            id = 3,
            icon = R.drawable.ic_star,
            text = "О разработке приложения",
            Brush.linearGradient(gradientForSelfCard),
            imageBg = null,
            descToAddiction = R.string.myself_history,
        )

    )

    var isWhiteTheme by mutableStateOf(false)
        private set
    private fun changeTheme() = run { isWhiteTheme = !isWhiteTheme }

    fun navigate(route: String) =
        navController.navigate(route)
    fun navigate(startRoute: String, endRoute: String) =
        navController.navigate(endRoute) {
            popUpTo(startRoute) {
                inclusive = true
            }
        }

    fun popBackStack() = navController.popBackStack()
    private fun showToast() =
        Toast
            .makeText(
                application.applicationContext,
                "Thats workggdfgd",
                Toast.LENGTH_SHORT)
            .show()

    val settingsContent = mapOf(
        0 to Pair("Включить обучалку") {navController.navigate(Screen.OnBoarding1.route)},
        1 to Pair("Обнулисть лайки/дизлайки") { showToast() },
        2 to Pair("Твоя почта") {  openAlertWindow(OPEN_EMAIL_ALERT) },
        3 to Pair("Включить Светлую тему") { changeTheme() },
        4 to Pair("Размер основного текста") { openAlertWindow(OPEN_TITLE_ALERT) },
        5 to Pair("Размер цитат") { openAlertWindow(OPEN_QUOTE_ALERT) }
    )
    var alertForTitle by mutableStateOf(false)
        private set
    var alertForQuote by mutableStateOf(false)
    var alertForEmail by mutableStateOf(false)
        private set

    var userEmail by mutableStateOf("")
        private set
    fun openAlertWindow(type: Int) = run {
        when(type) {
            OPEN_EMAIL_ALERT -> {alertForEmail = !alertForEmail}
            OPEN_TITLE_ALERT -> {alertForTitle = !alertForTitle}
            OPEN_QUOTE_ALERT -> { alertForQuote = !alertForQuote }
        }
    }
    fun changeUserEmail(value: String) = run { userEmail = value }
    var validateEmailVariable by mutableStateOf(false)
        private set
    fun validateEmailText(): String {
        return if (userEmail.isEmpty()) {
            "Введи свою почту"
        } else {
            "Изменить $userEmail"
        }
    }
    fun validateEmail(){
        if (userEmail.isNotEmpty() && userEmail.contains('@')) {
            validateEmailVariable = true
            return
        }
        validateEmailVariable = false
    }

    var userInformedAboutReact by mutableStateOf(false)
        private set
    fun informUserAboutReact() {
        if (userInformedAboutReact) {
            return
        }
        userInformedAboutReact = true
    }



    var fontSizeForQuote by mutableStateOf(13)
    var fontSizeForTitle by mutableStateOf(18)
        private set
    fun changeTextSizeForTitle(value: Int) = run {
        if (fontSizeForTitle.toString().isEmpty()) {
            fontSizeForTitle = 0
        }
        fontSizeForTitle = value
    }

    fun changeTextSizeForQuote(value: Int) = run {
        if (fontSizeForQuote.toString().isEmpty()) {
            fontSizeForQuote = 0
        }
        fontSizeForQuote = value
    }

    fun validateTitle() {
        if (fontSizeForTitle in 35 downTo 6) {
            fontSizeForTitle = 18
        }
    }
    fun validateQuote() {
        if (fontSizeForQuote in 23 downTo 4) {
            fontSizeForQuote = 13
        }
    }

    fun refreshData(value: Int) {
        when(value) {
            REFRESH_TITLE_SIZE -> { fontSizeForTitle = DEFAULT_TITLE_TEXT_SIZE }
            REFRESH_QUOTE_SIZE -> { fontSizeForQuote = DEFAULT_QUOTE_TEXT_SIZE}
        }

    }

}