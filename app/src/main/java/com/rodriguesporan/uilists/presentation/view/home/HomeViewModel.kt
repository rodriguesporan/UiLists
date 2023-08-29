package com.rodriguesporan.uilists.presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguesporan.uilists.data.model.RepositoriesDTO
import com.rodriguesporan.uilists.domain.usecase.FetchRepositoriesUseCase
import com.rodriguesporan.uilists.presentation.model.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(
    val fetchRepositoriesUseCase: FetchRepositoriesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    private var _repositories: RepositoriesDTO? = null
    val repositories: RepositoriesDTO?
        get() = _repositories

    fun onCreate() {
        fetchRepositories()
    }

    private fun fetchRepositories() {
        viewModelScope.launch {
            try {
                _repositories = fetchRepositoriesUseCase()
                _uiState.emit(HomeUiState.Success)
            } catch (exception: Exception) {
                _uiState.emit(HomeUiState.Error)
            }
        }
    }
}
