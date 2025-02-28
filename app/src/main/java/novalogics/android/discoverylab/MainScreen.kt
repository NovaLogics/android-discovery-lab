package novalogics.android.discoverylab

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
import novalogics.android.discoverylab.ui.theme.AndroidDiscoveryLabTheme

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
            text = "Welcome to Experiment Series" +
                    "\n\n" +
                    "02 / Suspend Functions - Kotlin Coroutines",
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDiscoveryLabTheme {
        MainScreen()
    }
}
