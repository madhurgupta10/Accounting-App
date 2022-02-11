package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Composable
fun CustomPriceInput(
    header: String,
    value: Float,
    modifier: Modifier,
    toggleBottomBar: (value: Boolean) -> Unit,
    onChange: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val focusManager = LocalFocusManager.current
    Column(
        modifier
            .padding(bottom = 20.dp)
            .height(IntrinsicSize.Min)
            .bringIntoViewRequester(bringIntoViewRequester)
    ) {
        Text(
            text = header,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        TextField(
            singleLine = true,
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent {
                    if (it.isFocused) {
                        coroutineScope.launch {
                            toggleBottomBar(false)
                            delay(20)
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(onDone = {
                coroutineScope.launch {
                    focusManager.clearFocus()
                    delay(20)
                    toggleBottomBar(true)
                }
            }),
            value = value.toString(),
            textStyle = MaterialTheme.typography.h3,
            onValueChange = onChange,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                disabledTextColor = Color.Transparent,
                backgroundColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}