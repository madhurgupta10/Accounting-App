package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R

@ExperimentalMaterialApi
@Composable
fun CustomDropDownInput(
    header: String,
    value: Int,
    modifier: Modifier
) {
    val options = listOf(1, 7, 30)
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[options.indexOf(value)]) }

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
                expanded = !expanded
            }
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                value = "Next $selectedOptionText Days",
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
                            selectedOptionText = selectionOption
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