package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory

@Composable
internal fun ScenarioListSuccess(
    scenarios: List<ScenarioModel>,
    modifier: Modifier = Modifier,
    onItemPressed: (scenarioId: Long) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .padding(20.dp),
    ) {
        itemsIndexed(scenarios) { _, scenario ->
            scenario.id?.let { scenarioId ->
                ScenarioListItem(
                    id = scenarioId,
                    scenario = scenario,
                    onItemPressed = onItemPressed,
                )
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
