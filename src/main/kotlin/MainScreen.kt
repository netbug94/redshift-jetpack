import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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

            Box(modifier = Modifier.fillMaxSize().weight(1f).padding(top = 35.dp),
                contentAlignment = Alignment.Center){
                Text("#####K", fontSize = smartText(), color = Color.White)
            }

            repeat(4) {
                Row(modifier = Modifier.fillMaxSize().weight(1f), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){
                    Button(modifier = Modifier.height(50.dp).width(100.dp), onClick = {  }) {

                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
        }
    }
}