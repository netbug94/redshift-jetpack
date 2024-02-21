package customs.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import customs.smartText

@Composable
fun leftButtonTxt() {
    val sText = smartText(.6f)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "M", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "a", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "x", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "")
        Text(text = "N", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "i", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "g", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "h", textAlign = TextAlign.Center, fontSize = sText)
        Text(text = "t", textAlign = TextAlign.Center, fontSize = sText)
    }
}
