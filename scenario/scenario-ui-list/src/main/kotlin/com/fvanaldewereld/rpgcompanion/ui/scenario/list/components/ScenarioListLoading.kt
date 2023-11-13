package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.common.ui.component.RpgCompanionTopAppBar
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme

@Composable
fun ScenarioListLoading() {
    Scaffold(
        topBar = { RpgCompanionTopAppBar(title = "Scenario List") },
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(size = 64.dp),
                strokeWidth = 6.dp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScenarioDetailLoadingPreview() {
    RPGCompanionTheme {
        ScenarioListLoading()
    }
}