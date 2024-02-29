package engine_helpers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

object SaveBoolean {
    private const val FILE_PATH = "RJP"
    private const val FILE_NAME = "MSState"
    fun saveBoolean(booleanValue: Boolean) {
        runBlocking {
            launch(Dispatchers.IO) {
                try {
                    val file = File("$FILE_PATH/$FILE_NAME")
                    file.writeText(booleanValue.toString())
                } catch (e: Exception) {
                    println("saveBooleanToFile: ${e.message}")
                }
            }
        }
    }
}