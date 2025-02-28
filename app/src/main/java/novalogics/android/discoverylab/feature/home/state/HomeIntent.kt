package novalogics.android.discoverylab.feature.home.state

import novalogics.android.discoverylab.core.arch.state.ViewIntent

sealed class HomeIntent: ViewIntent {
    data object LoadData : HomeIntent()
}
