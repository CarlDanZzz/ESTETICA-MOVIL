package com.example.estetica_movil.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Paleta morada clara
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF7E57C2),      // morado principal
    secondary = Color(0xFF9575CD),    // morado más claro
    tertiary = Color(0xFFB39DDB),     // morado pastel
    background = Color(0xFFF3E5F5),   // fondo lilita
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

// Paleta morada oscura
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFB39DDB),      // morado claro para contraste
    secondary = Color(0xFF9575CD),
    tertiary = Color(0xFF7E57C2),
    background = Color(0xFF311B92),   // fondo morado oscuro
    surface = Color(0xFF1A1A1A),
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun ESTETICAMOVILTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // desactivamos dynamic para forzar morado
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
