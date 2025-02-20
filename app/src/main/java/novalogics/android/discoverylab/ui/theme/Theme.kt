package novalogics.android.discoverylab.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Dark.primary,
    onPrimary = Dark.onPrimary,
    primaryContainer = Dark.primaryContainer,
    onPrimaryContainer = Dark.onPrimaryContainer,
    secondary = Dark.secondary,
    onSecondary = Dark.onSecondary,
    secondaryContainer = Dark.secondaryContainer,
    onSecondaryContainer = Dark.onSecondaryContainer,
    tertiary = Dark.tertiary,
    onTertiary = Dark.onTertiary,
    tertiaryContainer = Dark.tertiaryContainer,
    onTertiaryContainer = Dark.onTertiaryContainer,
    error = Dark.error,
    errorContainer = Dark.errorContainer,
    onError = Dark.onError,
    onErrorContainer = Dark.onErrorContainer,
    background = Dark.background,
    onBackground = Dark.onBackground,
    surface = Dark.surface,
    onSurface = Dark.onSurface,
    surfaceVariant = Dark.surfaceVariant,
    onSurfaceVariant = Dark.onSurfaceVariant,
    outline = Dark.outline,
    inverseOnSurface = Dark.inverseOnSurface,
    inverseSurface = Dark.inverseSurface,
    inversePrimary = Dark.inversePrimary,
    surfaceTint = Dark.surfaceTint,
    outlineVariant = Dark.outlineVariant,
    scrim = Dark.scrim
)

private val LightColorScheme = lightColorScheme(
    primary = Light.primary,
    onPrimary = Light.onPrimary,
    primaryContainer = Light.primaryContainer,
    onPrimaryContainer = Light.onPrimaryContainer,
    secondary = Light.secondary,
    onSecondary = Light.onSecondary,
    secondaryContainer = Light.secondaryContainer,
    onSecondaryContainer = Light.onSecondaryContainer,
    tertiary = Light.tertiary,
    onTertiary = Light.onTertiary,
    tertiaryContainer = Light.tertiaryContainer,
    onTertiaryContainer = Light.onTertiaryContainer,
    error = Light.error,
    errorContainer = Light.errorContainer,
    onError = Light.onError,
    onErrorContainer = Light.onErrorContainer,
    background = Light.background,
    onBackground = Light.onBackground,
    surface = Light.surface,
    onSurface = Light.onSurface,
    surfaceVariant = Light.surfaceVariant,
    onSurfaceVariant = Light.onSurfaceVariant,
    outline = Light.outline,
    inverseOnSurface = Light.inverseOnSurface,
    inverseSurface = Light.inverseSurface,
    inversePrimary = Light.inversePrimary,
    surfaceTint = Light.surfaceTint,
    outlineVariant = Light.outlineVariant,
    scrim = Light.scrim
)

@Composable
fun AndroidDiscoveryLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
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
