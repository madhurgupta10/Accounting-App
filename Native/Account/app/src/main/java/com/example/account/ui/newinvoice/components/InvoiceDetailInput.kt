package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.model.Address

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun InvoiceDetailInput() {
    Column(modifier = Modifier.padding(bottom = 60.dp)) {
        Heading("New Invoice")
        SubHeading("Bill From")
        AddressInput(
            address = Address(
                street = "19 Union Terrace",
                city = "London",
                postCode = "E1 3EZ",
                country = "United Kingdom",
            )
        )
        SubHeading("Bill To")
        ClientInput(
            name = "Alex Grim",
            email = "alexgrim@mail.com"
        )
        AddressInput(
            address = Address(
                street = "19 Union Terrace",
                city = "London",
                postCode = "E1 3EZ",
                country = "United Kingdom",
            )
        )
        CustomCalendarInput(
            header = "Invoice Date",
            value = " 21 Aug 2021",
            modifier = Modifier.fillMaxWidth()
        )
        CustomDropDownInput(
            header = "Payment Terms",
            value = 1,
            modifier = Modifier.fillMaxWidth()
        )
        CustomTextInput(
            header = "Project Description",
            value = "Graphic Design",
            modifier = Modifier.fillMaxWidth()
        )
    }
}