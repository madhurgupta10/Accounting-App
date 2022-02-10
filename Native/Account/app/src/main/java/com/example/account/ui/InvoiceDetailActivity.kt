package com.example.account.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.account.Constants
import com.example.account.model.Address
import com.example.account.model.Invoice
import com.example.account.model.InvoiceItem
import com.example.account.model.enums.InvoiceButton
import com.example.account.model.enums.InvoiceStatus
import com.example.account.ui.elements.ActivityTemplate
import com.example.account.ui.elements.GoBack
import com.example.account.ui.elements.InvoiceId
import com.example.account.ui.theme.getCardOnCardBlackColor
import com.example.account.ui.theme.getCardOnCardColor
import com.example.account.utils.*
import com.example.account.viewmodel.InvoiceDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InvoiceDetailActivity : ComponentActivity() {

    private val invoiceDetailViewModel: InvoiceDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val invoice: Invoice = intent.getSerializableExtra("invoice") as Invoice

        setContent {
            ActivityTemplate(
                content = {
                    InvoiceDetailActivityContent(this, invoice)
                },
                bottomBar = { modifier ->
                    BottomBar(modifier, invoice, invoiceDetailViewModel)
                }
            )
        }
    }
}

@Composable
fun InvoiceDetailActivityContent(activity: Activity, invoice: Invoice) {
    val status = getStatus(invoice.status)
    val bottomPadding = if (status == InvoiceStatus.Paid) 0.dp else Constants.outerPadding
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp)
    ) {
        GoBack(activity)
        Column(
            modifier = Modifier
                .padding(
                    top = 0.dp,
                    bottom = bottomPadding,
                    start = Constants.outerPadding,
                    end = Constants.outerPadding
                )
                .verticalScroll(rememberScrollState())
        ) {
            StatusCard(getStatus(invoice.status))
            DetailCard(invoice)
        }
    }
}

@Composable
fun DetailCard(invoice: Invoice) {
    val status = getStatus(invoice.status)
    val bottomPadding = if (status == InvoiceStatus.Paid) 30.dp else 140.dp
    Card(
        shape = Constants.cardShape,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .clip(Constants.cardShape)
            .padding(bottom = bottomPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(Constants.cardPadding),
        ) {
            Body(invoice)
        }
    }
}

@Composable
fun Body(invoice: Invoice) {
    Column {
        InvoiceId(invoice.id)
        InvoiceTitle(invoice.description)
        Address(invoice.senderAddress)
        Row(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 30.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                SubTitle(title = "Invoice Date", date = getInvoiceDate(invoice.invoiceDate))
                SubTitle(
                    title = "Payment Date",
                    date = getDueDate(invoice.invoiceDate, invoice.paymentTerms)
                )
            }
            Column {
                SubTitle(
                    title = "Bill To",
                    date = invoice.clientName,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Address(invoice.clientAddress)
            }
        }
        SubTitle(title = "Sent to", date = invoice.clientEmail)
        ItemsCard(invoice)
    }
}

@Composable
fun ItemsCard(invoice: Invoice) {
    Card(
        shape = Constants.cardShape,
        backgroundColor = getCardOnCardColor(),
        modifier = Modifier
            .padding(top = 30.dp, bottom = 20.dp)
            .clip(Constants.cardShape)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
        ) {
            Column(
                modifier = Modifier.padding(Constants.cardPadding),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                invoice.items.forEach { item ->
                    Item(item)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = getCardOnCardBlackColor())
                    .padding(Constants.cardPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Amount Due",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = getTotal(invoice.items),
                    fontSize = 22.sp,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }
        }
    }
}

@Composable
fun Item(item: InvoiceItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = item.name,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = "${item.quantity} x ${getPrice(item.price)}",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSurface,
            )
        }
        Text(
            text = getItemTotal(item),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun InvoiceTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.onBackground,
        modifier = Modifier.padding(bottom = 30.dp)
    )
}

@Composable
fun SubTitle(title: String, date: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = date,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = modifier
        )
    }
}

@Composable
fun Address(address: Address) {
    Text(
        text = address.street,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
    Text(
        text = address.city,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
    Text(
        text = address.postCode,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
    Text(
        text = address.country,
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
}

@Composable
fun StatusCard(status: InvoiceStatus) {
    Card(
        shape = Constants.cardShape,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .clip(Constants.cardShape)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(Constants.cardPadding),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Status",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                StatusButton(
                    modifier = Modifier,
                    type = status
                )
            }
        }
    }
}

@Composable
fun BottomBar(
    modifier: Modifier,
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel
) {
    val status = getStatus(invoice.status)
    if (status != InvoiceStatus.Paid) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(color = MaterialTheme.colors.surface)
                .padding(20.dp)
        ) {
            when (status) {
                InvoiceStatus.Pending -> {
                    EditButton(invoice, invoiceDetailViewModel)
                    DeleteButton(invoice, invoiceDetailViewModel)
                    MarkAsPaidButton(invoice, invoiceDetailViewModel)
                }
                InvoiceStatus.Draft -> {
                    EditButton(invoice, invoiceDetailViewModel)
                    DeleteButton(invoice, invoiceDetailViewModel)
                }
                else -> {}
            }
        }
    }
}

@Composable
fun MarkAsPaidButton(invoice: Invoice, invoiceDetailViewModel: InvoiceDetailViewModel) {
    InvoiceButton(InvoiceButton.MarkAsPaid,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                invoiceDetailViewModel.markInvoiceAsPaid(invoice)
            })
}

@Composable
fun DeleteButton(invoice: Invoice, invoiceDetailViewModel: InvoiceDetailViewModel) {
    InvoiceButton(InvoiceButton.Delete,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                invoiceDetailViewModel.deleteInvoice(invoice)
            })
}

@Composable
fun EditButton(invoice: Invoice, invoiceDetailViewModel: InvoiceDetailViewModel) {
    InvoiceButton(InvoiceButton.Edit,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                invoiceDetailViewModel.editInvoice(invoice)
            })
}

@Composable
fun InvoiceButton(type: InvoiceButton, modifier: Modifier) {
    var backgroundColor = MaterialTheme.colors.primary
    var foregroundColor = MaterialTheme.colors.onPrimary
    var text = "Mark as Paid"
    var startPadding = 30.dp
    var endPadding = 30.dp
    when (type) {
        InvoiceButton.Delete -> {
            backgroundColor = MaterialTheme.colors.error
            foregroundColor = MaterialTheme.colors.onError
            text = "Delete"
            startPadding = 20.dp
            endPadding = 20.dp
        }
        InvoiceButton.Edit -> {
            backgroundColor = getCardOnCardColor()
            foregroundColor = MaterialTheme.colors.onBackground
            text = "Edit"
            startPadding = 20.dp
            endPadding = 20.dp
        }
        else -> {}
    }
    Box(
        modifier = modifier.background(color = backgroundColor)
    ) {
        Text(
            text,
            color = foregroundColor,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(top = 15.dp, bottom = 15.dp, start = startPadding, end = endPadding)
        )
    }
}