package com.example.account

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.account.elements.ActivityTemplate
import com.example.account.elements.InvoiceId
import com.example.account.enums.InvoiceButton
import com.example.account.enums.InvoiceStatus
import com.example.account.ui.theme.*

class InvoiceDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityTemplate(
                bottomBar = { modifier ->
                    BottomBar(modifier)
                },
                content = {
                    InvoiceDetailActivityContent(this)
                }
            )
        }
    }
}

@Composable
fun InvoiceDetailActivityContent(activity: Activity) {
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
            StatusCard()
            DetailCard()
        }
    }
}

@Composable
fun DetailCard() {
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
            Body()
        }
    }
}

@Composable
fun Body() {
    Column {
        InvoiceId("RT3080")
        InvoiceTitle("Graphic Design")
        Address()
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
                SubTitle(title = "Invoice Date", date = "21 Aug 2021")
                SubTitle(title = "Payment Date", date = "20 Sept 2021")
            }
            Column {
                SubTitle(
                    title = "Bill To",
                    date = "Alex Grim",
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Address()
            }
        }
        SubTitle(title = "Sent to", date = "alexgrim@email.com")
        ItemsCard()
    }
}

@Composable
fun ItemsCard() {
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
                Item()
                Item()
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
                    text = "£ 156.00",
                    fontSize = 22.sp,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }
        }
    }
}

@Composable
fun Item() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "Banner Design",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = "1 x £156.00",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSurface,
            )
        }
        Text(
            text = "£156.00",
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
fun Address() {
    Text(
        text = "19 Union Terrace",
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
    Text(
        text = "London",
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
    Text(
        text = "E1 3EZ",
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
    Text(
        text = "United Kingdom",
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.onBackground,
    )
}

@Composable
fun StatusCard() {
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
                    type = InvoiceStatus.Pending
                )
            }
        }
    }
}

@Composable
fun GoBack(activity: Activity) {
    Row(modifier = Modifier
        .clickable {
            activity.finish()
        }
        .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_icon_arrow_left), "Go back",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(end = 20.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            "Go back", color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h3,
        )
    }
}

@Composable
fun BottomBar(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(color = MaterialTheme.colors.surface)
            .padding(20.dp)
    ) {
        MarkAsPaidButton(InvoiceButton.Edit)
        MarkAsPaidButton(InvoiceButton.Delete)
        MarkAsPaidButton(InvoiceButton.MarkAsPaid)
    }
}

@Composable
fun MarkAsPaidButton(type: InvoiceButton) {
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
        modifier = Modifier
            .clip(RoundedCornerShape(90.dp))
            .background(color = backgroundColor)
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