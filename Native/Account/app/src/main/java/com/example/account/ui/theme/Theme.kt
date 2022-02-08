package com.example.account.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = ColorPrimary,
    primaryVariant = Color2,
    secondary = Color2,
    secondaryVariant = Color2,
    background = Color3,
    surface = Color4,
    error = ColorError,
    onPrimary = ColorWhite,
    onSecondary = ColorWhite,
    onBackground = ColorWhite,
    onSurface = Color5,
    onError = ColorWhite
)

private val LightColorPalette = lightColors(
    primary = ColorPrimary,
    primaryVariant = Color2,
    secondary = Color2,
    secondaryVariant = Color2,
    background = Color3,
    surface = Color4,
    error = ColorError,
    onPrimary = ColorWhite,
    onSecondary = ColorWhite,
    onBackground = ColorWhite,
    onSurface = Color5,
    onError = ColorWhite
)

@Composable
fun getCardOnCardColor(darkTheme: Boolean = isSystemInDarkTheme()): Color {
    return if (darkTheme) {
        ColorCardOnCardDark
    } else {
        ColorCardOnCardLight
    }
}

@Composable
fun getCardOnCardBlackColor(darkTheme: Boolean = isSystemInDarkTheme()): Color {
    return if (darkTheme) {
        ColorBlack
    } else {
        ColorWhite
    }
}

@Composable
fun AccountTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}