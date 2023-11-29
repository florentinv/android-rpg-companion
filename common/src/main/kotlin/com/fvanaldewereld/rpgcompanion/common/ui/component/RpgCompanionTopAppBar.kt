package com.fvanaldewereld.rpgcompanion.common.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RpgCompanionTopAppBar(
    title: String = "",
    onBackButtonPressed: (() -> Unit)? = null,
) {
    TopAppBar(
        navigationIcon = {
            onBackButtonPressed?.let {
                IconButton(
                    onClick = it,
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back button")
                }
            }
        },
        title = { Text(title) },
    )
}

@Preview
@Composable
private fun RpgCompanionTopBarPreview() {
    RPGCompanionTheme {
        RpgCompanionTopAppBar(
            title = "Title",
            onBackButtonPressed = {},
        )
    }
}
