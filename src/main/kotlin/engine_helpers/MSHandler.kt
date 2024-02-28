package engine_helpers

import androidx.compose.runtime.Composable
import views.mainScreen1
import views.mainScreen2
import java.io.File

@Composable
    fun mainScreenHandler() {
    val filePath = "src/main/kotlin/MSState"
    when (val fileContent = File(filePath).readText()) {
        "true" -> mainScreen1()
        "false" -> mainScreen2()
        else -> println("Invalid content in the file: $fileContent")
    }
}