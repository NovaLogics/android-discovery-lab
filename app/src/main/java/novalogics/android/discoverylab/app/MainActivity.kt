package novalogics.android.discoverylab.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import novalogics.android.discoverylab.app.navigation.AppNavigation
import novalogics.android.discoverylab.core.theme.AndroidDiscoveryLabTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidDiscoveryLabTheme {
                AppNavigation()
            }
        }
    }
}
