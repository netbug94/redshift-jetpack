package customs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

@Composable
fun myScreen() {
    val apt = "sudo apt install redshift -y"
    val dnf = "sudo dnf install redshift -y"
    val nala = "sudo nala install redshift -y"
    val pacman = "sudo pacman install redshift -y"
    val zypper = "sudo zypper install redshift -y"
    val textList = listOf(apt, dnf, nala, pacman, zypper)

    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {

        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1.19f))

        Column(modifier = Modifier.fillMaxSize().weight(2f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.weight(2f))

            textList.forEach { text ->
                Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center) {
                        Button(onClick = {copyToClipboard(text)}) {
                            Text(text = "Copy $text", fontSize = smartText(.7f))
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(.81f))
    }
}

fun copyToClipboard(text: String) {
    val stringSelection = StringSelection(text)
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard
    clipboard.setContents(stringSelection, null)
}
