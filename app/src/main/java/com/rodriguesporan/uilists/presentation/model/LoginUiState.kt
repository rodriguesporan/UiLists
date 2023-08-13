package com.rodriguesporan.uilists.presentation.model

internal sealed class LoginUiState {
    object Initial : LoginUiState()
    object Redirecting : LoginUiState()
}
