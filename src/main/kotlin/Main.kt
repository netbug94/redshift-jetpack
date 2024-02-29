import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import customs.misc.olrScn
import engine_helpers.ScreenHandler.screenHandler

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        screenHandler()
        olrScn("olr")
    }
}
