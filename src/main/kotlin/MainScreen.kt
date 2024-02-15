import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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

        Column (modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(10f),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.fillMaxSize().weight(.8f))

            repeat(4) {
                Row(modifier = Modifier.fillMaxSize().weight(1f), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){
                    Button(onClick = {}) {

                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
        }
    }
}