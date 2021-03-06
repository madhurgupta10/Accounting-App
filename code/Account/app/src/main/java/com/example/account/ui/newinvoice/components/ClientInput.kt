package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun ClientInput(
    name: String,
    email: String,
    toggleBottomBar: (value: Boolean) -> Unit,
    onClickName: (String) -> Unit,
    onClickEmail: (String) -> Unit
) {
    Column {
        CustomTextInput(
            header = "Client's Name",
            value = name,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = onClickName
        )
        CustomTextInput(
            header = "Client's Email",
            value = email,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = onClickEmail
        )
    }
}