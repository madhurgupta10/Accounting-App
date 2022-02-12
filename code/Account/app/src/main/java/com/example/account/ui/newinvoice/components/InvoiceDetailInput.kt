package com.example.account.ui.newinvoice.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.account.model.Invoice
import com.example.account.utils.getInvoiceDate
import com.example.account.utils.getInvoiceDateForDbFormat
import com.vanpra.composematerialdialogs.datetime.date.datepicker

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun InvoiceDetailInput(
    invoice: Invoice,
    isNew: Boolean,
    toggleBottomBar: (value: Boolean) -> Unit
) {
    var senderAddressStreet by rememberSaveable { mutableStateOf(invoice.senderAddress.street) }
    var senderAddressCity by rememberSaveable { mutableStateOf(invoice.senderAddress.city) }
    var senderAddressPostCode by rememberSaveable { mutableStateOf(invoice.senderAddress.postCode) }
    var senderAddressCountry by rememberSaveable { mutableStateOf(invoice.senderAddress.country) }

    var clientName by rememberSaveable { mutableStateOf(invoice.clientName) }
    var clientEmail by rememberSaveable { mutableStateOf(invoice.clientEmail) }

    var clientAddressStreet by rememberSaveable { mutableStateOf(invoice.clientAddress.street) }
    var clientAddressCity by rememberSaveable { mutableStateOf(invoice.clientAddress.city) }
    var clientAddressPostCode by rememberSaveable { mutableStateOf(invoice.clientAddress.postCode) }
    var clientAddressCountry by rememberSaveable { mutableStateOf(invoice.clientAddress.country) }

    var invoiceDate by rememberSaveable { mutableStateOf( getInvoiceDate(invoice.invoiceDate)) }

    var paymentTerms by rememberSaveable { mutableStateOf(invoice.paymentTerms) }

    var description by rememberSaveable { mutableStateOf(invoice.description) }

    Column(modifier = Modifier.padding(bottom = 50.dp)) {
        Heading("New Invoice", invoice, isNew)
        SubHeading("Bill From")
        AddressInput(
            street = senderAddressStreet,
            city = senderAddressCity,
            postCode = senderAddressPostCode,
            country = senderAddressCountry,
            onClickStreet = {
                senderAddressStreet = it
                invoice.senderAddress.street = senderAddressStreet
            },
            onClickCity = {
                senderAddressCity = it
                invoice.senderAddress.city = senderAddressCity
            },
            onClickPostCode = {
                senderAddressPostCode = it
                invoice.senderAddress.postCode = senderAddressPostCode
            },
            onClickCountry = {
                senderAddressCountry = it
                invoice.senderAddress.country = senderAddressCountry
            },
            toggleBottomBar = toggleBottomBar
        )
        SubHeading("Bill To")
        ClientInput(
            name = clientName,
            email = clientEmail,
            toggleBottomBar = toggleBottomBar,
            onClickName = {
                clientName = it
                invoice.clientName = clientName
            },
            onClickEmail = {
                clientEmail = it
                invoice.clientEmail = clientEmail
            }
        )
        AddressInput(
            street = clientAddressStreet,
            city = clientAddressCity,
            postCode = clientAddressPostCode,
            country = clientAddressCountry,
            onClickStreet = {
                clientAddressStreet = it
                invoice.clientAddress.street = clientAddressStreet
            },
            onClickCity = {
                clientAddressCity = it
                invoice.clientAddress.city = clientAddressCity
            },
            onClickPostCode = {
                clientAddressPostCode = it
                invoice.clientAddress.postCode = clientAddressPostCode
            },
            onClickCountry = {
                clientAddressCountry = it
                invoice.clientAddress.country = clientAddressCountry
            },
            toggleBottomBar = toggleBottomBar
        )
        CustomCalendarInput(
            header = "Invoice Date",
            value = invoiceDate,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            content = {
                datepicker {
                    invoiceDate = getInvoiceDate(it.toString())
                    invoice.invoiceDate = getInvoiceDateForDbFormat(invoiceDate)
                }
            }
        )
        CustomDropDownInput(
            header = "Payment Terms",
            value = paymentTerms,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = {
                paymentTerms = it
                invoice.paymentTerms = paymentTerms
            }
        )
        CustomTextInput(
            header = "Project Description",
            value = description,
            modifier = Modifier.fillMaxWidth(),
            toggleBottomBar = toggleBottomBar,
            onClick = {
                description = it
                invoice.description = description
            }
        )
    }
}