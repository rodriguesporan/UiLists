package com.rodriguesporan.uilists.presentation.view.routing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.application.UiListsApplication
import com.rodriguesporan.uilists.di.session.SessionProvider
import com.rodriguesporan.uilists.presentation.model.RoutingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class RoutingViewModel(
    session: SessionProvider
): ViewModel() {

    private val _uiState = MutableStateFlow<RoutingUiState>(RoutingUiState.Loading)
    val uiState: StateFlow<RoutingUiState> = _uiState.asStateFlow()

    init {
        val state = if (session.isAuthorized()) {
            RoutingUiState.Authorized
        } else {
            RoutingUiState.NotAuthenticated
        }
        viewModelScope.launch {
            _uiState.emit(state)
        }
    }
}
