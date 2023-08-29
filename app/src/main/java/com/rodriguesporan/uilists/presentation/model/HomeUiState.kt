package com.rodriguesporan.uilists.presentation.model

internal sealed class HomeUiState {
    object Error : HomeUiState()
    object Loading : HomeUiState()
    object Success : HomeUiState()
}
