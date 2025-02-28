package novalogics.android.discoverylab.core.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    // Extra small rounded corners (e.g., subtle elements like input fields)
    extraSmall = RoundedCornerShape(size = 2.dp),

    // Small rounded corners (e.g., small buttons, chips)
    small = RoundedCornerShape(size = 4.dp),

    // Medium rounded corners (e.g., cards, medium buttons)
    medium = RoundedCornerShape(size = 8.dp),

    // Large rounded corners (e.g., large cards, dialogs)
    large = RoundedCornerShape(size = 16.dp),

    // Extra large rounded corners (e.g., hero sections, large containers)
    extraLarge = RoundedCornerShape(size = 24.dp)
)
