package com.rodriguesporan.uilists.presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguesporan.uilists.domain.usecase.FetchRepositoriesUseCase
import com.rodriguesporan.uilists.presentation.model.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(
    val useCase: FetchRepositoriesUseCase
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
