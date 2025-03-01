package novalogics.android.discoverylab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import novalogics.android.discoverylab.ui.theme.AndroidDiscoveryLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidDiscoveryLabTheme {
                MainScreen()
            }
        }
        //Test Kotlin Coroutines
        testCoroutines(context = this)
    }
}

