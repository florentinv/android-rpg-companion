package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

data class ScenarioModel(
    val documentName: String? = "",
    val tree: TreeModel? = null,
)

enum class TextType {
    NORMAL_TEXT,
    HEADING_1,
    HEADING_2,
    HEADING_3,
    TITLE,
}