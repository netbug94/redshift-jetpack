package engine_helpers

import java.io.IOException

class RedshiftController {
    companion object {
        private fun redshiftCommand(runThis: String) {
            try {
                val process = ProcessBuilder("bash", "-c", runThis).start()

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
// Extra error handling
            } catch (e: IOException) {
                println("Error: ${e.message}")
            } catch (e: InterruptedException) {
                println("Error: ${e.message}")
            }
        }
// Reset controller
        fun redshiftCommandX(scriptName: String) {
    redshiftCommand(scriptName)
        }
// Night controller
        fun redshiftCommandN(scriptName: String) {
    redshiftCommand(scriptName)
        }
// Day controller
        fun redshiftCommandD(scriptName: String) {
    redshiftCommand(scriptName)
        }
    }
}
