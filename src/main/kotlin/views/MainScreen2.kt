package views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import customs.res.*
import engine_helpers.Navi

@Composable
fun mainScreen2() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.MainScn2) }
    val btnTxt = smartText(.6f)

    val sliderValue = remember { mutableStateOf(0f) }

// Slider commands
    val temperatureList = listOf(
        "redshift -O 1000k",
        "redshift -O 2000k",
        "redshift -O 2500k",
        "redshift -O 3500k",
        "redshift -O 4500k",
        "redshift -O 5500k",
        "",
        "redshift -O 25000K",
        "redshift -O 7500k",
        "redshift -O 8500k",
        "redshift -O 9500k",
        "redshift -O 11000k",
        "redshift -O 12500k"
    )

    when (currentScreen) {
        is Navi.MainScn2 -> {
// Head container
            Column(
                modifier = Modifier.fillMaxSize().background(ErgoGray).padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxSize().weight(1.2f).background(DeepBlack),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize().weight(1f)
                            .clickable(interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false, radius = 10.dp),
                                onClick = { currentScreen = Navi.MainScn2 })
                    ) {
                        Image(
                            painter = painterResource("HomePng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(15.dp)
                        )
                    }

                    Text("Redshift-JetPack", color = HyperBlue, fontSize = smartText(1f))

                    Box(
                        modifier = Modifier.fillMaxSize().weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false, radius = 10.dp),
                                onClick = { currentScreen = Navi.SettingScn })
                    ) {
                        Image(
                            painter = painterResource("SettingsPng240B.png"),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize().padding(16.dp)
                        )
                    }
                }
                Divider(modifier = Modifier.height(1.dp), color = ErgoGray)
// Body container
                Row(modifier = Modifier.fillMaxSize().weight(10f).background(DeepGray),
                    horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
// Slider
                    Slider(
                        value = sliderValue.value,
                        onValueChange = { newValue ->
                            // Update the slider value when it changes
                            sliderValue.value = newValue
                        }
                    )
                }
            }
        }
// Navi tail
        Navi.SettingScn -> settingScreen()
        Navi.MainScn1 -> mainScreen1()
    }
}