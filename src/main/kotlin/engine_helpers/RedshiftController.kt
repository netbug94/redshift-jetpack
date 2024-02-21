package engine_helpers

import java.io.IOException

class RedshiftController {
    companion object {
        private fun redshiftCommand(scriptPath: String) {
            try {
                val process = ProcessBuilder("bash", scriptPath).start()

                // Redirect error stream to standard output to capture errors
                process.errorStream.reader().use { reader ->
                    reader.forEachLine { line -> println(line) }
                }

                // Read process output
                process.inputStream.bufferedReader().use { reader ->
                    reader.forEachLine { line -> println(line) }
                }

                // Wait for process to finish
                val exitVal = process.waitFor()

                if (exitVal == 0) {
                    println("Success!")
                } else {
                    println("Error: $exitVal")
                }
            } catch (e: IOException) {
                println("Error: ${e.message}")
            } catch (e: InterruptedException) {
                println("Error: ${e.message}")
            }
        }
// Reset controller
        fun redshiftCommandX(scriptName: String) {
            val scriptPath = "src/main/kotlin/bashfiles/$scriptName"
            redshiftCommand(scriptPath)
        }
// Night controller
        fun redshiftCommandN(scriptName: String) {
            val scriptPath = "src/main/kotlin/bashfiles/nightlight/$scriptName"
            redshiftCommand(scriptPath)
        }
// Day controller
        fun redshiftCommandD(scriptName: String) {
            val scriptPath = "src/main/kotlin/bashfiles/daylight/$scriptName"
            redshiftCommand(scriptPath)
        }
    }
}
