package com.fvanaldewereld.rpgcompanion.scenario.feature.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fvanaldewereld.rpgcompanion.R
import com.fvanaldewereld.rpgcompanion.scenario.ScenarioMockFactory
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import com.fvanaldewereld.rpgcompanion.ui.theme.RPGCompanionTheme
import com.fvanaldewereld.rpgcompanion.ui.theme.Typography

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
fun ScenarioDetailSuccess(scenario: ScenarioModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            scenario.title?.value?.let { titleText ->
                Text(
                    text = titleText,
                    style = Typography.h4,
                    textAlign = TextAlign.Center,
                )
            }
        }

        item {
            scenario.author?.name?.let { authorName ->
                Text(
                    text = stringResource(R.string.scenario_detail_page_author, authorName),
                    style = Typography.h6.copy(
                        fontStyle = FontStyle.Italic,
                        color = Color.LightGray,
                    ),
                )
            }
        }

        item {
            scenario.information?.nbPlayers?.let { nbPlayers ->
                Chip(
                    onClick = {},
                    modifier = Modifier.padding(2.dp),
                    colors = ChipDefaults.chipColors(Color.Green.copy(alpha = 0.5F)),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null)
                    },
                ) {
                    Text(
                        nbPlayers.toString(),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        item {
            scenario.information?.genres?.let { genres ->
                FlowRow(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(horizontal = 15.dp),
                ) {
                    genres.forEach { genre ->
                        Chip(
                            onClick = {},
                            modifier = Modifier.padding(2.dp),
                            colors = ChipDefaults.chipColors(Color.Red.copy(alpha = 0.5F)),
                        ) {
                            Text(
                                genre,
                                textAlign = TextAlign.Center,
                            )
                        }
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
                        Chip(
                            onClick = {},
                            modifier = Modifier.padding(2.dp),
                            colors = ChipDefaults.chipColors(Color.Blue.copy(alpha = 0.5F)),
                        ) {
                            Text(
                                theme,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
            }
        }

        item {
            scenario.summary?.let { summary ->
                Text(
                    "Summary",
                    style = Typography.h5,
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
                    style = Typography.h5,
                    modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                )
                places.places?.forEach { place ->
                    Text(
                        place.name ?: "/",
                        style = Typography.h6,
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
                    style = Typography.h5,
                    modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                )
                characters.characters?.forEach { character ->
                    Text(
                        character.name ?: "/",
                        style = Typography.h6,
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
                    style = Typography.h5,
                    modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                )
                content.chapters?.forEach { chapter ->
                    Text(
                        chapter.name ?: "/",
                        style = Typography.h6,
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


@Preview(showBackground = true)
@Composable
fun ScenarioDetailSuccessPreview() {
    RPGCompanionTheme {
        ScenarioDetailSuccess(scenario = ScenarioMockFactory.scenarioModel)
    }
}