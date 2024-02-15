import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun mainScreen() {
    Column(modifier = Modifier.fillMaxSize().background(ErgoGray), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Row(modifier = Modifier.fillMaxSize().weight(1f).background(Color.DarkGray),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text("JetPack-Redshift", color = Color.White, fontSize = smartText())
        }

        Row (modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(10f)) {

        }
    }
}