package com.rodriguesporan.uilists.presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.application.UiListsApplication
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubRepositoriesUseCase
import com.rodriguesporan.uilists.presentation.model.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(
    val useCase: FetchGitHubRepositoriesUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onCreate() {
        viewModelScope.launch {
            try {
                val repositories = useCase()
                _uiState.emit(HomeUiState.Success(repositories))
            } catch (exception: Exception) {
                _uiState.emit(HomeUiState.Error)
            }
        }
    }
}
