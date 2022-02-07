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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.account.ui.theme.AccountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccountTheme {
                TopAppBar()
            }
        }
    }
}

@Preview(showBackground = true)
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