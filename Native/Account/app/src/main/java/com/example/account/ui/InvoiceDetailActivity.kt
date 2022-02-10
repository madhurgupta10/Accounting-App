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
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.account.utils.Constants
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
        val invoice = intent.getSerializableExtra("invoice") as Invoice

        setContent {
            ActivityTemplate(
                content = {
                    InvoiceDetailActivityContent(this, invoice)
                },
                bottomBar = { modifier ->
                    BottomBar(modifier, invoice, invoiceDetailViewModel, this)
                }
            )
        }
    }
}

@Composable
fun InvoiceDetailActivityContent(activity: Activity, invoice: Invoice) {
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
                    bottom = Constants.outerPadding,
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
    Card(
        shape = Constants.cardShape,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .clip(Constants.cardShape)
            .padding(bottom = 140.dp)
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
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(color = MaterialTheme.colors.surface)
            .padding(20.dp)
    ) {
        when (getStatus(invoice.status)) {
            InvoiceStatus.Pending -> {
                EditButton(invoice, invoiceDetailViewModel)
                DeleteButton(invoice, invoiceDetailViewModel, activity)
                MarkAsPaidButton(invoice, invoiceDetailViewModel, activity)
            }
            InvoiceStatus.Draft -> {
                EditButton(invoice, invoiceDetailViewModel)
                DeleteButton(invoice, invoiceDetailViewModel, activity)
            }
            else -> {
                DeleteButton(invoice, invoiceDetailViewModel, activity)
            }
        }
    }
}

@Composable
fun MarkAsPaidButton(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity
) {
    CustomButton(InvoiceButton.MarkAsPaid,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                invoiceDetailViewModel.markInvoiceAsPaid(invoice)
                activity.finish()
            })
}

@Composable
fun DeleteButton(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity,
) {
    val openDialog = remember { mutableStateOf(false) }
    DeleteDialog(invoice, invoiceDetailViewModel, activity, openDialog)
    CustomButton(InvoiceButton.Delete,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                openDialog.value = true
            })
}

@Composable
fun EditButton(invoice: Invoice, invoiceDetailViewModel: InvoiceDetailViewModel) {
    CustomButton(InvoiceButton.Edit,
        Modifier
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                invoiceDetailViewModel.editInvoice(invoice)
            })
}

@Composable
fun CustomButton(type: InvoiceButton? = null, modifier: Modifier) {
    var backgroundColor = getCardOnCardColor()
    var foregroundColor = MaterialTheme.colors.onBackground
    var text = "Cancel"
    var startPadding = 20.dp
    var endPadding = 20.dp
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
        InvoiceButton.MarkAsPaid -> {
            backgroundColor = MaterialTheme.colors.primary
            foregroundColor = MaterialTheme.colors.onPrimary
            text = "Mark as Paid"
            startPadding = 30.dp
            endPadding = 30.dp
        }
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

@Composable
fun DeleteDialog(
    invoice: Invoice,
    invoiceDetailViewModel: InvoiceDetailViewModel,
    activity: Activity,
    openDialog: MutableState<Boolean>
) {
    if (openDialog.value) {
        AlertDialog(
            modifier = Modifier.clip(RoundedCornerShape(10.dp)),
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = "Confirm Deletion",
                    fontSize = 22.sp,
                    color = MaterialTheme.colors.onBackground,
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to delete invoice " +
                            "#${invoice.id}? This action cannot be undone.",
                    lineHeight = 20.sp,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface,
                )
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(bottom = 30.dp, end = 30.dp, start = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    CustomButton(modifier = Modifier
                        .padding(end = 10.dp)
                        .clip(RoundedCornerShape(90.dp))
                        .clickable {
                            openDialog.value = false
                        })
                    CustomButton(InvoiceButton.Delete,
                        Modifier
                            .clip(RoundedCornerShape(90.dp))
                            .clickable {
                                openDialog.value = false
                                invoiceDetailViewModel.deleteInvoice(invoice)
                                activity.finish()
                            })
                }
            }
        )
    }
}