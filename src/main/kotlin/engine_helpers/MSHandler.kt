package engine_helpers

import androidx.compose.runtime.Composable
import views.mainScreen1
import views.mainScreen2
import java.io.File

@Composable
    fun mainScreenHandler() {
    val filePath = "src/main/kotlin/MSState"
    when (val fileContent = File(filePath).readText()) {
        "Buttons" -> mainScreen1()
        "Slider" -> mainScreen2()
        else -> println("mainScreenHandler: $fileContent")
    }
}