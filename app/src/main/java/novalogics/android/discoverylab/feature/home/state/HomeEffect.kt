package novalogics.android.discoverylab.feature.home.state

import novalogics.android.discoverylab.core.arch.state.ViewEffect

sealed class HomeEffect : ViewEffect {
    data class ShowMessage(val message: String) : HomeEffect()
}
