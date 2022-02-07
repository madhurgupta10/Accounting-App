package com.example.account.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.account.R

val spartanFontFamily = FontFamily(
    Font(R.font.spartan_bold, weight = FontWeight.Bold),
    Font(R.font.spartan_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.spartan_light, weight = FontWeight.Light),
    Font(R.font.spartan_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.spartan_medium, weight = FontWeight.Medium),
    Font(R.font.spartan_regular, weight = FontWeight.Normal),
    Font(R.font.spartan_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.spartan_thin, weight = FontWeight.Thin),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = spartanFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = spartanFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = spartanFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h1 = TextStyle(
        fontFamily = spartanFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = spartanFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        fontFamily = spartanFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)