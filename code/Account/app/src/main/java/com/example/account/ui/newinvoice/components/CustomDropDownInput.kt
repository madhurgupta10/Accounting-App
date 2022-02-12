package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R
import com.example.account.utils.Constants.Companion.options
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CustomDropDownInput(
    header: String,
    value: Int,
    modifier: Modifier,
    toggleBottomBar: (value: Boolean) -> Unit,
    onClick: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier
            .padding(bottom = 20.dp)
            .height(IntrinsicSize.Min)
    ) {
        Text(
            text = header,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onExpandedChange = {
                coroutineScope.launch {
                    focusManager.clearFocus()
                    delay(20)
                    toggleBottomBar(true)
                    expanded = !expanded
                }
            }
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                value = "Next $value Days",
                shape = RoundedCornerShape(4.dp),
                textStyle = MaterialTheme.typography.h3,
                onValueChange = {},
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_icon_arrow_down), "payment terms",
                        tint = MaterialTheme.colors.primary,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onBackground,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = MaterialTheme.colors.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onClick(selectionOption)
                            expanded = false
                        }
                    ) {
                        Text(text = "Next $selectionOption Days")
                    }
                }
            }
        }
    }
}