package com.rodriguesporan.uilists.presentation.model

internal sealed interface RoutingUiState {
    object Loading : RoutingUiState
    object Authorized : RoutingUiState
    object NotAuthenticated : RoutingUiState
}
