package com.rodriguesporan.uilists.presentation.model

internal sealed class LoginUiEvent {
    object OpenTrendingScreen : LoginUiEvent()
    object OpenErrorScreen : LoginUiEvent()
}
