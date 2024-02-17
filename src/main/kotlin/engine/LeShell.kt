package engine

object LeShell {
    fun shellRun() {
        val binaryPath = "src/main/kotlin/api/PkillScript.sh"
        ProcessBuilder("bash", binaryPath).start()
    }
}