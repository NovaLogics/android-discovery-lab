package novalogics.android.discoverylab

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import novalogics.android.discoverylab.ui.theme.AndroidDiscoveryLabTheme

const val TAG: String = "MainScreen"

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
        coroutineTestFunction()
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding()
            .background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        Text(
            text = "Welcome to Experiment Series\n\n01 / kotlin coroutines",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp)
                .padding(innerPadding)

        )
    }
}


fun coroutineTestFunction(){

    GlobalScope.launch {
        delay(2000L)
        Log.d(TAG, "Hello from COROUTINE | Thread : ${Thread.currentThread().name}")
    }
    Log.d(TAG, "Hello from thread | Thread : ${Thread.currentThread().name}")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDiscoveryLabTheme {
        MainScreen()
    }
}
