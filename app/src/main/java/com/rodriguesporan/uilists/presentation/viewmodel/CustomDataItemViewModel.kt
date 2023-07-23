package com.rodriguesporan.uilists.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.di.UiListsApplication
import com.rodriguesporan.uilists.domain.CustomDataItemUseCase
import com.rodriguesporan.uilists.model.CardMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class CustomDataItemViewModel(
    private val useCase: CustomDataItemUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<CardMessage>>(emptyList())
    val uiState: StateFlow<List<CardMessage>> = _uiState.asStateFlow()

    fun getItems() {
        viewModelScope.launch {
            _uiState.emit(useCase.getItems(10))
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContainer = (this[APPLICATION_KEY] as UiListsApplication).appContainer
                CustomDataItemViewModel(appContainer.customDataItemDatasource)
            }
        }
    }
}
