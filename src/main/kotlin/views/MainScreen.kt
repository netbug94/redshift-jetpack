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
import customs.buttons.leftButtonTxt
import customs.buttons.rightButtonTxt
import customs.res.*
import engine_helpers.Navi
import engine_helpers.RedshiftController.Companion.redshiftCommandD
import engine_helpers.RedshiftController.Companion.redshiftCommandN
import engine_helpers.RedshiftController.Companion.redshiftCommandX

@Composable
fun mainScreen() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.MainScn) }
    val nightLight = listOf("2000k", "2500k", "3500k", "4500k", "5500k")
    val dayLight = listOf("7500k", "8500k", "9500k", "11000k", "12500k")
    var selectedButton by remember { mutableStateOf("") }
    val btnTxt = smartText(.6f)

// Commands for left buttons
    val nightButton0 = "redshift -O 2000k"
    val nightButton1 = "redshift -O 2500k"
    val nightButton2 = "redshift -O 3500k"
    val nightButton3 = "redshift -O 4500k"
    val nightButton4 = "redshift -O 5500k"

// Max side and middle buttons
    val maxNight = "redshift -O 1000k"
    val resetButton = ""
    val maxDay = "redshift -O 25000K"

// Commands for right buttons
    val dayButton5 = "redshift -O 7500k"
    val dayButton6 = "redshift -O 8500k"
    val dayButton7 = "redshift -O 9500k"
    val dayButton8 = "redshift -O 11000k"
    val dayButton9 = "redshift -O 12500k"

    when (currentScreen) {
        is Navi.MainScn -> {
// Head container
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
                            modifier = Modifier.fillMaxSize().padding(15.dp)
                        )
                    }

                    Text("Redshift-JetPack", color = HyperBlue, fontSize = smartText(1f))

                    Box(modifier = Modifier.fillMaxSize().weight(1f)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false, radius = 10.dp),
                            onClick = { currentScreen = Navi.SettingScn })) {
                        Image(painter = painterResource("SettingsPng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(16.dp)
                        )
                    }
                }
                Divider(modifier = Modifier.height(1.dp), color = ErgoGray)
// Body container
                Row(modifier = Modifier.fillMaxSize().weight(10f).background(DeepGray),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
// Left box
                    Column(modifier = Modifier.fillMaxSize().weight(1.6f), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.weight(1.8f))
// Left button
                        Row(modifier = Modifier.fillMaxSize().weight(7.2f), verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
                            Button(modifier = Modifier.fillMaxSize().weight(1f),
                                colors = ButtonDefaults.buttonColors(DeepPurple),
                                onClick = { selectedButton = "Max Night"; redshiftCommandN(maxNight) }) {
                                leftButtonTxt()
                            }
                            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
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
                                    colors = ButtonDefaults.buttonColors(DeepPurple),
                                    onClick = {
                                        selectedButton = name
                                        // Execute command based on selectedButton
                                        when (selectedButton) {
                                            "2000k" -> redshiftCommandN(nightButton0)
                                            "2500k" -> redshiftCommandN(nightButton1)
                                            "3500k" -> redshiftCommandN(nightButton2)
                                            "4500k" -> redshiftCommandN(nightButton3)
                                            "5500k" -> redshiftCommandN(nightButton4)
                                            else -> {
                                            }
                                        }
                                    }
                                ) {
                                    Text(text = name, fontSize = btnTxt)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
                    }
// Middle box
                    Column(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(2f)) {
                        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(2f))
// Text in the middle
                        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(8f),
                            contentAlignment = Alignment.Center) {
                            Text(selectedButton, color = HyperBlue, fontSize = smartText(1f))
                        }
// Reset button
                        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(2f).padding(horizontal = 20.dp)){
                            Button(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp),
                                colors = ButtonDefaults.buttonColors(DeepPurple),
                                onClick = { selectedButton = "X" ; redshiftCommandX(resetButton) }) {
                                Text("Reset", fontSize = btnTxt)
                            }
                        }
                        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
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
                                    colors = ButtonDefaults.buttonColors(DeepPurple),
                                    onClick = {
                                        selectedButton = name
                                        // Execute command based on selectedButton
                                        when (selectedButton) {
                                            "7500k" -> redshiftCommandD(dayButton5)
                                            "8500k" -> redshiftCommandD(dayButton6)
                                            "9500k" -> redshiftCommandD(dayButton7)
                                            "11000k" -> redshiftCommandD(dayButton8)
                                            "12500k" -> redshiftCommandD(dayButton9)
                                            else -> {
                                            }
                                        }
                                    }
                                ) {
                                    Text(text = name, fontSize = btnTxt)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.fillMaxSize().weight(.5f))
                    }
// Right box
                    Column(modifier = Modifier.fillMaxSize().weight(1.6f), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.weight(1.8f))
// Right button
                        Row(modifier = Modifier.fillMaxSize().weight(7.2f), verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {
                            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
                            Button(modifier = Modifier.fillMaxSize().weight(1f),
                                colors = ButtonDefaults.buttonColors(DeepPurple),
                                onClick = { selectedButton = "Max Day"; redshiftCommandD(maxDay) }) {
                                rightButtonTxt()
                            }
                            Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).weight(1f))
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
// Navi tail
        Navi.SettingScn -> settingScreen()
    }
}