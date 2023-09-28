package com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme

@Composable
fun SplashScreen(onAnimationFinished : () -> Unit) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Asset("animation_ln0885pz.json"))
    val progress by animateLottieCompositionAsState(composition)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.fillMaxSize(0.7F),
        )
        // Quand progress == 1.0 c'est qu el'animation est finie, on passe dans le callback
        if(progress == 1.0f){
            onAnimationFinished.invoke()
        }

    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    RPGCompanionTheme {
        SplashScreen {}
    }
}