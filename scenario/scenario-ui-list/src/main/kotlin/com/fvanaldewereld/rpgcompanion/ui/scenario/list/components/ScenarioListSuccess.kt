package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.common.ui.component.RpgCompanionTopAppBar
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory

@Composable
internal fun ScenarioListSuccess(
    scenarios: List<ScenarioModel>,
    onFabPressed: () -> Unit = {},
    onBackButtonPressed: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            RpgCompanionTopAppBar(
                title = "Scenario List",
                onBackButtonPressed = onBackButtonPressed,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFabPressed,
            ) {
                Icon(Icons.Filled.Add, "Add new scenario button")
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(20.dp),
        ) {
            itemsIndexed(scenarios) { index, scenario ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Canvas(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .size(6.dp),
                    ) {
                        drawCircle(Color.Black)
                    }
                    Text("Scenario n°$index", textDecoration = TextDecoration.Underline)
                    Text(" : \"${scenario.title?.value}\"")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScenarioDetailSuccessPreview() {
    RPGCompanionTheme {
        ScenarioListSuccess(scenarios = listOf(ScenarioModelMockFactory.scenarioModel))
    }
}
