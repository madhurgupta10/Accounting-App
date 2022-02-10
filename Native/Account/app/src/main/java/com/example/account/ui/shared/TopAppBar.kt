package com.example.account.ui.shared

import android.app.Activity
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.account.R

@Composable
fun TopAppBar(showGoBack: Boolean, activity: Activity?) {
    Column {
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
        if (showGoBack && activity != null) {
            GoBack(activity)
        }
    }
}
