package chuco.joel.gapsi.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class GapsiCustomColors(
    val background_color: Color,
    val text_color_welcome: Color,
)

val LocalCustomColors = staticCompositionLocalOf {
    GapsiCustomColors(
        background_color = Color.White,
        text_color_welcome = Color.Black,
    )
}

object GapsiTheme {
    val colors: GapsiCustomColors
        @Composable
        get() = LocalCustomColors.current
}