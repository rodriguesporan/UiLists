package com.rodriguesporan.uilists.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.di.UiListsApplication
import com.rodriguesporan.uilists.domain.SimpleDataItemUseCase
import com.rodriguesporan.uilists.model.Affirmation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class SimpleDataItemViewModel(
    private val useCase: SimpleDataItemUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<Affirmation>>(emptyList())
    val uiState: StateFlow<List<Affirmation>> = _uiState.asStateFlow()

    fun getItems() {
        viewModelScope.launch {
            _uiState.emit(useCase.getItems(100))
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContainer = (this[APPLICATION_KEY] as UiListsApplication).appContainer
                SimpleDataItemViewModel(appContainer.simpleDataItemDatasource)
            }
        }
    }
}
