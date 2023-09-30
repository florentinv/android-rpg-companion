package com.fvanaldewereld.rpgcompanion.splashScreen.feature.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Asset("animation_ln0885pz.json"))
    val progress by animateLottieCompositionAsState(composition)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LottieAnimation(
            composition = composition,
            iterations = 1,
            modifier = Modifier.fillMaxSize(0.7F),
        )

        if (progress == 1.0f) {
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