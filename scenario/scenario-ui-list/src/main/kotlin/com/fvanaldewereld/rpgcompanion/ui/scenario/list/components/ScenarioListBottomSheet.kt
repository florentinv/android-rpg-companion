@file:OptIn(ExperimentalMaterial3Api::class)

package com.fvanaldewereld.rpgcompanion.ui.scenario.list.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.common.ui.theme.Typography
import com.fvanaldewereld.rpgcompanion.ui.scenario.list.R

//https://docs.google.com/document/d/1YMuTjXvyU_sZFOu8PlvX1DNlJ7t1h7ne4yQvDSWHE54/edit?usp=sharing
@SuppressLint("UnrememberedMutableState")
@Composable
internal fun ScenarioListBottomSheet(
    modifier: Modifier = Modifier,
    goToScenarioDetail: (scenarioId: Long) -> Unit = {},
    addScenario: (scenarioUrl: String, (scenarioId: Long) -> Unit) -> Unit = { _, _ -> run {} },
    hideBottomSheet: () -> Unit = {},
) {
    var inputURL by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(
            20.dp,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(stringResource(R.string.scenarioList_success_bottomSheet_title), style = Typography.titleMedium)
        TextField(
            value = inputURL,
            onValueChange = { inputURL = it },
            label = { Text(stringResource(R.string.scenarioList_success_bottomSheet_textfield_label)) },
            placeholder = { Text(stringResource(R.string.scenarioList_success_bottomSheet_placeholder)) },
        )
        Button(
            onClick = {
                hideBottomSheet()
                addScenario(inputURL, goToScenarioDetail)
            },
        ) {
            Text(stringResource(R.string.scenarioList_success_bottomSheet_submitButton_label))
        }
    }
}

@Preview
@Composable
private fun ScenarioListBottomSheetPreview() {
    RPGCompanionTheme {
        ScenarioListBottomSheet()
    }
}