package views

import engine_helpers.Navi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import customs.*
import engine_helpers.ClipBoardHandler.copyClipboard
import java.io.File

@Composable
fun settingScreen() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.SettingScn) }
    val apt = "sudo apt install redshift -y"
    val dnf = "sudo dnf install redshift -y"
    val nala = "sudo nala install redshift -y"
    val pacman = "sudo pacman install redshift -y"
    val zypper = "sudo zypper install redshift -y"
    val textList = listOf(apt, dnf, nala, pacman, zypper)

    val filePath = "src/main/kotlin/MSState"
    var buttonState by remember { mutableStateOf("Slider") }
    LaunchedEffect(Unit) {
        val file = File(filePath)
        if (file.exists()) {
            buttonState = file.readText()
        }
    }

    when (currentScreen) {
        is Navi.SettingScn -> {
            Column(modifier = Modifier.fillMaxSize().background(ErgoGray).padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Row(modifier = Modifier.fillMaxSize().weight(1.2f).background(DeepBlack),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
// Left head
                    Row(modifier = Modifier.fillMaxSize().weight(1f)) {
                        Spacer(modifier = Modifier.fillMaxSize().weight(1f))
                        Image(painter = painterResource("HomePng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(15.dp)
                                .clickable(interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false, radius = 10.dp),
                                    onClick = { currentScreen = Navi.MainScn })
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.fillMaxSize().weight(1f))
                    }
// Middle head
                    Text("Redshift-JetPack", color = HyperBlue, fontSize = smartText(1f))
// Right head
                    Row(modifier = Modifier.fillMaxSize().weight(1f)) {
                        Spacer(modifier = Modifier.fillMaxSize().weight(1f))
                        Image(painter = painterResource("SettingsPng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(16.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false, radius = 10.dp),
                                    onClick = { currentScreen = Navi.SettingScn })
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.fillMaxSize().weight(1f))
                    }
                }
                Divider(modifier = Modifier.height(1.dp), color = ErgoGray)

                Row(modifier = Modifier.fillMaxSize().weight(10f).background(DeepGray),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
// Left middle box
                    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
// Install buttons (true middle)
                    Column(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1.7f),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.fillMaxSize().weight(1f).padding(top = 35.dp),
                            contentAlignment = Alignment.Center) {
                            Text("Install redshift", fontSize = smartText(.9f), color = HyperBlue)
                        }
                        textList.forEachIndexed { _, text ->
                            Row(modifier = Modifier.fillMaxSize().weight(1f),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically) {
                                Button(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp),
                                    colors = ButtonDefaults.buttonColors(DeepPurple), // Assuming you have a color defined somewhere
                                    onClick = { copyClipboard(text) }) {
                                    Text(text = "cp $text", fontSize = smartText(.6f))
                                }
                            }
                        }
                        Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
                    }
// Right middle box
                    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
                }
            }
        }
// Navi tail
        Navi.MainScn -> mainScreen()
        Navi.MainScn2 -> mainScreen2()
    }
}