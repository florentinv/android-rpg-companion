package com.fvanaldewereld.rpgcompanion.home.feature.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fvanaldewereld.rpgcompanion.R

@Composable
fun HomeScreen(
    onAccessButtonPressed: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(stringResource(R.string.home_page_welcome_text))
            Button(onClick = onAccessButtonPressed) {
                Text(stringResource(R.string.home_page_access_scenarios_button_label))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen(
        onAccessButtonPressed = {},
    )
}