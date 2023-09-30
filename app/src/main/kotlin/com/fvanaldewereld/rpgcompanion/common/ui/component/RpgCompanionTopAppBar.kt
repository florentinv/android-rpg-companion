package com.fvanaldewereld.rpgcompanion.common.ui.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fvanaldewereld.rpgcompanion.common.ui.theme.RPGCompanionTheme

@Composable
fun RpgCompanionTopAppBar(
    title: String = "",
    onBackButtonPressed: (() -> Unit)? = null,
) {
    TopAppBar(
        navigationIcon = onBackButtonPressed?.let {
            {
                IconButton(
                    onClick = it,
                ) {
                    Icon(Icons.Filled.ArrowBack, "Back button")
                }
            }
        },
        title = { Text(title) },
    )
}

@Preview
@Composable
fun RpgCompanionTopBarPreview() {
    RPGCompanionTheme {
        RpgCompanionTopAppBar(
            title = "Title",
            onBackButtonPressed = {}
        )
    }
}