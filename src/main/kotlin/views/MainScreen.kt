package views

import customs.DeepBlack
import customs.DeepGray
import customs.DeepPurple
import customs.ErgoGray
import customs.HyperBlue
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import customs.smartText

@Composable
fun mainScreen() {
    val nightLight = listOf("B1", "B2", "B3", "B4", "B5")
    val dayLight = listOf("B6", "B7", "B8", "B9", "B10")
    var selectedButton by remember {mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize().background(ErgoGray).padding(1.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.fillMaxSize().weight(1.2f).background(DeepBlack),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text("JetPack-Redshift", color = HyperBlue, fontSize = smartText(.9f))
        }
        Divider(modifier = Modifier.height(1.dp), color = ErgoGray)

        Row(modifier = Modifier.fillMaxSize().weight(10f).background(DeepGray),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
// Left box
            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1.6f))
// Nightlight buttons
            Column(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1.5f),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.fillMaxSize().weight(1f).padding(top = 35.dp),
                    contentAlignment = Alignment.Center) {
                    Text("NightLight", fontSize = smartText(.8f), color = HyperBlue)
                }
                nightLight.forEachIndexed { _, name ->
                    Row(modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Button(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp),
                            colors = ButtonDefaults.buttonColors(DeepPurple), // Assuming you have a color defined somewhere
                            onClick = { selectedButton = name }) {
                            Text(text = name)
                        }
                    }
                }
                Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
            }
// Middle box
            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(2f), contentAlignment = Alignment.Center) {
                Text(selectedButton, color = HyperBlue, fontSize = smartText(1f))
            }
// Daylight buttons
            Column(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1.5f),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.fillMaxSize().weight(1f).padding(top = 35.dp),
                    contentAlignment = Alignment.Center) {
                    Text("DayLight", fontSize = smartText(.8f), color = HyperBlue)
                }
                dayLight.forEachIndexed { _, name ->
                    Row(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Button(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp),
                            colors = ButtonDefaults.buttonColors(DeepPurple), // Assuming you have a color defined somewhere
                            onClick = { selectedButton = name }) {
                            Text(text = name)
                        }
                    }
                }
                Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
            }
// Right box
            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1.6f))
        }
    }
}