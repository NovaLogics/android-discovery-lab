package novalogics.android.discoverylab.core.theme

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

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
    systemTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = determineColorScheme(systemTheme, dynamicColor)
    val view = LocalView.current

    if (!view.isInEditMode) {
        ApplyEdgeToEdgeSettings(
            view = view,
            isDarkTheme = systemTheme,
            statusBarColor = colorScheme.surface
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}

/**
 * Determines the color scheme based on theme and dynamic color support
 */
@Composable
private fun determineColorScheme(
    isDarkTheme: Boolean,
    dynamicColor: Boolean
): ColorScheme {
    return if (dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (isDarkTheme) DarkColorScheme else LightColorScheme
    }
}

/**
 * Applies edge-to-edge settings for the window
 */
@Composable
private fun ApplyEdgeToEdgeSettings(
    view: View,
    isDarkTheme: Boolean,
    statusBarColor: Color = Color.Transparent,
    navigationBarColor: Color = Color.Transparent
) {
    SideEffect {
        setUpEdgeToEdge(
            view = view,
            isDarkTheme = isDarkTheme,
            statusBarColor = statusBarColor,
            navigationBarColor = navigationBarColor
        )
    }
}

/**
 * Configures the window for edge-to-edge display
 */
private fun setUpEdgeToEdge(
    view: View,
    isDarkTheme: Boolean,
    statusBarColor: Color,
    navigationBarColor: Color,
) {
    val window = (view.context as Activity).window
    WindowCompat.setDecorFitsSystemWindows(window, false)

    window.statusBarColor = statusBarColor.toArgb()
    window.navigationBarColor = resolveNavigationBarColor(
        isDarkTheme = isDarkTheme,
        navigationBarColor = navigationBarColor
    )

    val insetsController = WindowCompat.getInsetsController(window, view)
    insetsController.isAppearanceLightStatusBars = !isDarkTheme
    insetsController.isAppearanceLightNavigationBars = !isDarkTheme
}

/**
 * Resolves the navigation bar color based on Android version and theme
 */
@ColorInt
private fun resolveNavigationBarColor(
    isDarkTheme: Boolean,
    navigationBarColor: Color
): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        navigationBarColor.toArgb()
    } else {
        if (isDarkTheme) {
            LEGACY_DARK_NAVIGATION_BAR_COLOR
        } else {
            LEGACY_LIGHT_NAVIGATION_BAR_COLOR
        }.toArgb()
    }
}
