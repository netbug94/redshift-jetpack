package views

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
import engine_helpers.Navi
import engine_helpers.RedshiftController.Companion.redshiftCommandA
import engine_helpers.RedshiftController.Companion.redshiftCommandB

@Composable
fun mainScreen() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.MainScn) }
    val nightLight = listOf("2000k", "2500k", "3500k", "4500k", "5500k")
    val dayLight = listOf("7500k", "8500k", "9500k", "11000k", "12500k")
    var selectedButton by remember { mutableStateOf("") }

    when (currentScreen) {
        is Navi.MainScn -> {
            Column(modifier = Modifier.fillMaxSize().background(ErgoGray).padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Row(modifier = Modifier.fillMaxSize().weight(1.2f).background(DeepBlack),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

                    Box(modifier = Modifier.fillMaxSize().weight(1f)
                        .clickable(interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false, radius = 10.dp),
                            onClick = { currentScreen = Navi.MainScn })) {
                        Image(painter = painterResource("HomePng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(13.dp)
                        )
                    }

                    Text("JetPack-Redshift", color = HyperBlue, fontSize = smartText(1f))

                    Box(modifier = Modifier.fillMaxSize().weight(1f)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false, radius = 10.dp),
                            onClick = { currentScreen = Navi.SettingScn })) {
                        Image(painter = painterResource("SettingsPng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(14.dp)
                        )
                    }
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
                                    onClick = {
                                        selectedButton = name
                                        // Execute command based on selectedButton
                                        when (selectedButton) {
                                            "2000k" -> redshiftCommandA("NightLight0.sh")
                                            "2500k" -> redshiftCommandA("NightLight1.sh")
                                            "3500k" -> redshiftCommandA("NightLight2.sh")
                                            "4500k" -> redshiftCommandA("NightLight3.sh")
                                            "5500k" -> redshiftCommandA("NightLight4.sh")
                                            else -> {
                                            }
                                        }
                                    }
                                ) {
                                    Text(text = name)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
                    }
// Middle box
                    Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(2f),
                        contentAlignment = Alignment.Center) {
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
                                    onClick = {
                                        selectedButton = name
                                        // Execute command based on selectedButton
                                        when (selectedButton) {
                                            "7500k" -> redshiftCommandB("DayLight5.sh")
                                            "8500k" -> redshiftCommandB("DayLight6.sh")
                                            "9500k" -> redshiftCommandB("DayLight7.sh")
                                            "11000k" -> redshiftCommandB("DayLight8.sh")
                                            "12500k" -> redshiftCommandB("DayLight9.sh")
                                            else -> {
                                            }
                                        }
                                    }
                                ) {
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

        Navi.SettingScn -> settingScreen()
    }
}