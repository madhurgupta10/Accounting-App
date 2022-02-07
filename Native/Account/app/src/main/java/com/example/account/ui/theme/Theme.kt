package com.example.account.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Color1,
    primaryVariant = Color2,
    secondary = Color2,
    background = Color3,
    surface = Color4,
    onPrimary = Color13,
    onSecondary = Color13,
    onBackground = Color13,
    onSurface = Color5
)

private val LightColorPalette = lightColors(
    primary = Color1,
    primaryVariant = Color2,
    secondary = Color2,
    background = Color3,
    surface = Color4,
    onPrimary = Color13,
    onSecondary = Color13,
    onBackground = Color13,
    onSurface = Color5
)

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