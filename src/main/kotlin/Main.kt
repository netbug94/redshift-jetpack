import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import customs.olrScn
import views.MSHanlder.msHandler

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        msHandler()
        olrScn("olr")
    }
}
