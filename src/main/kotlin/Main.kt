import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import customs.myScreen
import customs.olrScn

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        myScreen()
        olrScn("\uD83C\uDF35olr")
    }
}
