package com.example.account

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.ui.theme.AccountTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccountTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background)
                ) {
                    Box {
                        TopAppBar()
                        Header()
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    Column(modifier = Modifier.padding(top = 100.dp, start = 20.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .width(200.dp)
                .height(IntrinsicSize.Min)
        ) {
            NoInvoiceHeader()
            Buttons(modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Composable
fun Buttons(modifier: Modifier) {
    Row(modifier = modifier.padding(end = 20.dp)) {
        FilterComposable(
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        AddNewButton(modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun AddNewButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    90.dp,
                    90.dp,
                    90.dp,
                    90.dp
                )
            )
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
fun FilterComposable(modifier: Modifier) {
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
fun NoInvoiceHeader() {
    Column {
        Text(
            "Invoices",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1
        )
        Text(
            "No invoices", color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun TopAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .width(200.dp)
            .height(IntrinsicSize.Min)
            .background(color = MaterialTheme.colors.surface)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp))
                .width(60.dp)
                .height(60.dp)
                .background(color = MaterialTheme.colors.primary)
        )
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