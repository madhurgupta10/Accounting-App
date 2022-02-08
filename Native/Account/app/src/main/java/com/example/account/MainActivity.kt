package com.example.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.account.elements.ActivityTemplate
import com.example.account.elements.InvoiceId
import com.example.account.enums.InvoiceStatus
import com.example.account.ui.theme.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityTemplate(
                content = {
                    MainActivityContent(this)
                }
            )
        }
    }
}

@Composable
fun Body(modifier: Modifier, invoices: List<String>?, context: Context) {
    if (invoices?.isNotEmpty() == true) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(Constants.outerPadding),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(invoices) { item ->
                InvoiceCard(context)
            }
        }
    } else {
        NoInvoiceBody(modifier)
    }
}

@Composable
fun InvoiceCard(context: Context) {
    Card(
        shape = Constants.cardShape,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .clip(Constants.cardShape)
            .clickable {
                context.startActivity(Intent(context, InvoiceDetailActivity::class.java))
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(Constants.cardPadding),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InvoiceId("RT3080")
                Text(
                    text = "Jensen Huang",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Due 19 Aug 2021",
                        style = MaterialTheme.typography.subtitle1,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = "£ 1,800.90",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )
                }
                StatusButton(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    type = InvoiceStatus.Pending
                )
            }
        }
    }
}

@Composable
fun StatusButton(modifier: Modifier, type: InvoiceStatus) {
    var backgroundColor = ColorPaidBackground
    var foregroundColor = ColorPaidForeground
    var text = "Paid"
    when (type) {
        InvoiceStatus.Pending -> {
            backgroundColor = ColorPendingBackground
            foregroundColor = ColorPendingForeground
            text = "Pending"
        }
        InvoiceStatus.Draft -> {
            backgroundColor = ColorDraftBackground
            foregroundColor = ColorDraftForeground
            text = "Draft"
        }
        else -> {}
    }

    Card(
        shape = RoundedCornerShape(6.dp),
        backgroundColor = backgroundColor,
        modifier = modifier
            .width(100.dp),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.padding(
                top = 10.dp,
                bottom = 10.dp
            ),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .fillMaxHeight()
                    .clip(CircleShape)
                    .background(foregroundColor)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = text,
                fontSize = 12.sp,
                color = foregroundColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 7.dp)
            )
        }
    }
}

@Composable
fun MainActivityContent(context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 100.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .width(200.dp)
                .height(IntrinsicSize.Min)
        ) {
            InvoiceHeader(num = 5)
            Buttons(modifier = Modifier.align(Alignment.CenterVertically))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Body(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                invoices = listOf("1", "2", "3", "4", "5"),
                context = context
            )
        }
    }
}

@Composable
fun Buttons(modifier: Modifier) {
    Row(modifier = modifier) {
        FilterButton(
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        AddNewButton(modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun AddNewButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(90.dp))
            .background(color = MaterialTheme.colors.primary)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.onPrimary)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_icon_plus),
                    "New",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Text(
                "New", color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp, end = 5.dp)
            )
        }
    }
}

@Composable
fun FilterButton(modifier: Modifier) {
    Row(modifier = modifier) {
        Text(
            "Filter", color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h3,
        )
        Icon(
            painter = painterResource(R.drawable.ic_icon_arrow_down), "Filter List",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(top = 5.dp, start = 10.dp, end = 20.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun InvoiceHeader(num: Int?) {
    var numInvoice = "No invoices"
    if (num != null && num > 0) {
        numInvoice = if (num > 1) {
            "$num invoices"
        } else {
            "$num invoice"
        }
    }
    Column {
        Text(
            "Invoices",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1
        )
        Text(
            numInvoice, color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun NoInvoiceBody(modifier: Modifier) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Min)
            .height(IntrinsicSize.Min)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_illustration_empty), "No Invoice",
            tint = androidx.compose.ui.graphics.Color.Unspecified,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp)
        )
        Text(
            "There is nothing here",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
        Text(
            "Create an invoice by clicking on New button and get started",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}

@Composable
fun TopAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(color = MaterialTheme.colors.surface)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp))
                .width(60.dp)
                .height(60.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.primaryVariant
                        ),
                        startY = 5.0f
                    )
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_logo), "Logo",
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .align(Alignment.Center)
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_icon_sun), "Change Theme",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .align(Alignment.CenterVertically)
            )
            Divider(
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(0.2.dp)
            )
            Image(
                painter = painterResource(R.drawable.image_avatar), "Profile Pic",
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}