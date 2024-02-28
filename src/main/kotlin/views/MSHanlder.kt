package views

import androidx.compose.runtime.Composable
import java.io.File

object MSHanlder {
    @Composable
    fun msHandler() {
        val filePath = "src/main/kotlin/MSState"
        when (val fileContent = File(filePath).readText()) {
            "true" -> mainScreen()
            "false" -> mainScreen2()
            else -> println("Invalid content in the file: $fileContent")
        }
    }
}
fun saveBooleanToFile(booleanValue: Boolean) {
    val filePath = "src/main/kotlin"
    val fileName = "MSState"
    val file = File("$filePath/$fileName")
    file.writeText(booleanValue.toString())
}