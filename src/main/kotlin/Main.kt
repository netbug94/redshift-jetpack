import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import customs.res.olrScn
import views.mainScreen2

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        mainScreen2()
        olrScn("olr")
    }
}
