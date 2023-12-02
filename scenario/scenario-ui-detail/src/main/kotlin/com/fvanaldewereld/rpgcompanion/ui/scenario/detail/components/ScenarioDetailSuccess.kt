package com.fvanaldewereld.rpgcompanion.ui.scenario.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.api.domain.scenario.models.ScenarioModel
import com.fvanaldewereld.rpgcompanion.common.ui.component.RpgCompanionTopAppBar
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.common.ui.theme.Typography
import com.fvanaldewereld.rpgcompanion.mockFactory.ScenarioModelMockFactory
import com.fvanaldewereld.rpgcompanion.ui.scenario.detail.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ScenarioDetailSuccess(
    scenario: ScenarioModel,
    onBackButtonPressed: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            RpgCompanionTopAppBar(
                title = "${scenario.id} // Scenario Detail ${scenario.title?.value?.let { "- $it" }}",
                onBackButtonPressed = onBackButtonPressed,
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                scenario.title?.value?.let { titleText ->
                    Text(
                        text = titleText,
                        style = Typography.headlineMedium,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            item {
                scenario.author?.name?.let { authorName ->
                    Text(
                        text = stringResource(R.string.scenario_detail_page_author, authorName),
                        style = Typography.titleLarge.copy(
                            fontStyle = FontStyle.Italic,
                            color = Color.LightGray,
                        ),
                    )
                }
            }

            item {
                scenario.information?.nbPlayers?.let { nbPlayers ->
                    AssistChip(
                        onClick = {},
                        modifier = Modifier.padding(2.dp),
                        colors = AssistChipDefaults.assistChipColors(Color.Green.copy(alpha = 0.5F)),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Person, contentDescription = null)
                        },
                        label = {
                            Text(
                                nbPlayers.toString(),
                                textAlign = TextAlign.Center,
                            )
                        },
                    )
                }
            }

            item {
                scenario.information?.genres?.let { genres ->
                    FlowRow(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(horizontal = 15.dp),
                    ) {
                        genres.forEach { genre ->
                            AssistChip(
                                onClick = {},
                                modifier = Modifier.padding(2.dp),
                                colors = AssistChipDefaults.assistChipColors(Color.Red.copy(alpha = 0.5F)),
                                label = {
                                    Text(
                                        genre,
                                        textAlign = TextAlign.Center,
                                    )
                                },
                            )
                        }
                    }
                }
            }

            item {
                scenario.information?.themes?.let { themes ->
                    FlowRow(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(horizontal = 15.dp),
                    ) {
                        themes.forEach { theme ->
                            AssistChip(
                                onClick = {},
                                modifier = Modifier.padding(2.dp),
                                colors = AssistChipDefaults.assistChipColors(Color.Blue.copy(alpha = 0.5F)),
                                label = {
                                    Text(
                                        theme,
                                        textAlign = TextAlign.Center,
                                    )
                                },
                            )
                        }
                    }
                }
            }

            item {
                scenario.summary?.let { summary ->
                    Text(
                        "Summary",
                        style = Typography.headlineSmall,
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                    )
                    summary.text?.paragraphs?.forEach { paragraph ->
                        Text(
                            paragraph,
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                        )
                    }
                }
            }

            item {
                scenario.places?.let { places ->
                    Text(
                        "Places",
                        style = Typography.headlineSmall,
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                    )
                    places.places?.forEach { place ->
                        Text(
                            place.name ?: "/",
                            style = Typography.titleLarge,
                            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                        )
                        place.description?.paragraphs?.forEach { paragraph ->
                            Text(
                                paragraph,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                            )
                        }
                    }
                }
            }

            item {
                scenario.characters?.let { characters ->
                    Text(
                        "Characters",
                        style = Typography.headlineSmall,
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                    )
                    characters.characters?.forEach { character ->
                        Text(
                            character.name ?: "/",
                            style = Typography.titleLarge,
                            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                        )
                        character.description?.paragraphs?.forEach { paragraph ->
                            Text(
                                paragraph,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                            )
                        }
                    }
                }
            }

            item {
                scenario.chapters?.let { content ->
                    Text(
                        "Content",
                        style = Typography.headlineSmall,
                        modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                    )
                    content.chapters?.forEach { chapter ->
                        Text(
                            chapter.name ?: "/",
                            style = Typography.titleLarge,
                            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                        )
                        chapter.description?.paragraphs?.forEach { paragraph ->
                            Text(
                                paragraph,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun ScenarioDetailSuccessPreview() {
    RPGCompanionTheme {
        ScenarioDetailSuccess(scenario = ScenarioModelMockFactory.scenarioModelWithoutId)
    }
}
