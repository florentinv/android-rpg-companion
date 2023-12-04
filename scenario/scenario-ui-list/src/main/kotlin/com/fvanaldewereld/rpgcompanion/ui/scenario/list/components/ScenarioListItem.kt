package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory

@Composable
internal fun ScenarioListItem(
    id: Long,
    scenario: ScenarioModel,
    modifier: Modifier = Modifier,
    goToScenarioDetail: (scenarioId: Long) -> Unit = {},
    deleteScenario: (scenarioId: Long) -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { goToScenarioDetail(id) }.padding(vertical = 10.dp),
    ) {
        Canvas(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .size(6.dp),
        ) {
            drawCircle(Color.Black)
        }
        Text("$id", textDecoration = TextDecoration.Underline)
        Text(" : \"${scenario.title?.value}\"")
        Text(" / ${scenario.chapters?.chapters?.size} chap.")
        Text(" / ${scenario.characters?.characters?.size} char.")
        Text(" / ${scenario.places?.places?.size} pl.")
        IconButton(
            onClick = { deleteScenario(id) },
            content = {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "delete scenario n°$id"
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScenarioListItemPreview() {
    RPGCompanionTheme {
        ScenarioListItem(id = 1, scenario = ScenarioModelMockFactory.scenarioModelWithoutId)
    }
}