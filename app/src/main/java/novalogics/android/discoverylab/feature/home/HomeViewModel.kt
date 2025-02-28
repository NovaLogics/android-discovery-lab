package novalogics.android.discoverylab.feature.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import novalogics.android.discoverylab.core.arch.BaseViewModel
import novalogics.android.discoverylab.feature.home.state.HomeEffect
import novalogics.android.discoverylab.feature.home.state.HomeIntent
import novalogics.android.discoverylab.feature.home.state.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    BaseViewModel<HomeIntent, HomeUiState, HomeEffect>(HomeUiState()) {

    init {
        handleIntent(HomeIntent.LoadData)
    }

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.LoadData -> displayData()
        }
    }

    private fun displayData() {
        viewModelScope.launch {
            updateState { copy(data = "Hello From MVI Base") }
        }
    }

}
