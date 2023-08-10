package com.fvanaldewereld.rpgcompanion.scenario.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TreeModel(
    var content: String = "",
    val children: MutableList<TreeModel> = mutableListOf(),
    val type: TextType = TextType.NORMAL_TEXT,
) : Parcelable