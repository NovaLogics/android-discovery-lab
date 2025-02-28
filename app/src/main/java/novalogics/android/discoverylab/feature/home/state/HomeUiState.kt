package novalogics.android.discoverylab.feature.home.state

import novalogics.android.discoverylab.core.arch.state.ViewUiState

data class HomeUiState(
    val isLoading: Boolean = false,
    val data: String = "",
    val error: String? = null,
) : ViewUiState
