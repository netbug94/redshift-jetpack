import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import customs.olrScn
import engine_helpers.screenHandler

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        screenHandler()
        olrScn("olr")
    }
}
