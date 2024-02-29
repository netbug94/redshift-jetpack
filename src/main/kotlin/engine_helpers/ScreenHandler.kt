package engine_helpers

import androidx.compose.runtime.Composable
import views.mainScreenA
import views.mainScreenB
import java.io.File

@Composable
fun screenHandler() {
    val filePath = "src/main/kotlin/MSState"
    when (val fileContent = File(filePath).readText()) {
        "true" -> mainScreenA()
        "false" -> mainScreenB()
        else -> println("screenHandler: $fileContent")
    }
}
