package com.rodriguesporan.uilists.presentation.view.simple

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.application.UiListsApplication
import com.rodriguesporan.uilists.domain.model.Affirmation
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase
import com.rodriguesporan.uilists.presentation.model.DataView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class SimpleDataItemViewModel(
    private val useCase: GetAffirmationsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<DataView>>(emptyList())
    val uiState: StateFlow<List<DataView>> = _uiState.asStateFlow()

    fun getItems() {
        viewModelScope.launch {
            val items: List<Affirmation> = useCase()
            _uiState.emit(items.map { item -> DataView.SingleLabel(item.title) })
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContainer = (this[APPLICATION_KEY] as UiListsApplication).appContainer
                SimpleDataItemViewModel(appContainer.getSimpleAffirmationsUseCase)
            }
        }
    }
}