package com.fvanaldewereld.rpgcompanion.scenario.feature.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.scenario.ScenarioMockFactory
import com.fvanaldewereld.rpgcompanion.scenario.feature.model.ScenarioUi
import com.fvanaldewereld.rpgcompanion.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.ui.theme.Typography

@Composable
fun ScenarioDetailSuccess(scenarioUI: ScenarioUi) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "${scenarioUI.documentName}",
            style = Typography.h3,
        )
        Text(
            text = "${scenarioUI.tree?.content}",
            style = Typography.h5,
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
        ) {
            scenarioUI.tree?.let { tree ->
                tree.children.forEach { childTree ->
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp, bottom = 5.dp, start = 20.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = childTree.content,
                                style = Typography.h6,
                            )
                        }
                    }
                    childTree.children.forEach { body ->
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp, bottom = 5.dp, start = 20.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = body.content,
                                    style = Typography.body1,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScenarioDetailSuccessPreview() {
    RPGCompanionTheme {
        ScenarioDetailSuccess(scenarioUI = ScenarioMockFactory.scenarioUi)
    }
}