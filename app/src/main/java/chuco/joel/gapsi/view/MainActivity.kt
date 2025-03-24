package chuco.joel.gapsi.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import chuco.joel.gapsi.navigation.NavigationRoute
import chuco.joel.gapsi.ui.theme.GapsiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GapsiTheme (
                darkTheme = true
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = GapsiTheme.colors.background_color
                ) {
                    val navController = rememberNavController()
                    NavigationRoute(navController = navController)
                }
            }
        }
    }
}
