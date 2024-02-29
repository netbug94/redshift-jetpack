package engine_helpers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

fun saveBoolean(booleanValue: Boolean) {
    val filePath = "src/main/kotlin/MSState"
    runBlocking {
        launch(Dispatchers.IO) {
            try {
                val file = File(filePath)
                file.writeText(booleanValue.toString())
            } catch (e: Exception) {
                println("saveBooleanToFile: ${e.message}")
            }
        }
    }
}