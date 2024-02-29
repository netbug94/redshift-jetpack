package engine_helpers

import androidx.compose.runtime.Composable
import views.mainScreenA
import views.mainScreenB
import java.io.File

object ScreenHandler {
    private const val FILE_PATH = "RJP"
    private const val FILE_NAME = "MSState"
    init {
        File(FILE_PATH).mkdirs()
        val file = File("$FILE_PATH/$FILE_NAME")
        if (!file.exists()) {
            file.createNewFile() // Create the file if it does not exist
        }
    }
    @Composable
    fun screenHandler() {
        val filePath = "RJP/MSState"
        val fileContent = File(filePath).readText()
        val ramValue = "true"
        val fileValue = fileContent.ifEmpty { ramValue }

        when (fileValue) {
            "true" -> mainScreenA()
            "false" -> mainScreenB()
            else -> {
                println("screenHandler: $fileValue")
            }
        }
    }
}