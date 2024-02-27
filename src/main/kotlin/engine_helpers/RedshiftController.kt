package engine_helpers

import java.io.IOException

object RedshiftController {
    fun redshiftCommand(runThis: String) {
        try {
            val process = ProcessBuilder("bash", "-c", "redshift -x ; $runThis").start()

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
                println("Command failure: $exitVal")
            }
// Extra error handling
        } catch (e: IOException) {
            println("Command failure: ${e.message}")
        } catch (e: InterruptedException) {
            println("Command failure: ${e.message}")
        }
    }
}
