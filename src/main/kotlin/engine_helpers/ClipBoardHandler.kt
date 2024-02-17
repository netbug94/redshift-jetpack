package engine_helpers

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

object ClipBoardHandler {
    fun copyClipboard(text: String) {
        val stringSelection = StringSelection(text)
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(stringSelection, null)
    }
}
