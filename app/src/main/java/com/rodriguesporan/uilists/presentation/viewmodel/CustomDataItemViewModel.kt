package com.rodriguesporan.uilists.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.UiListsApplication
import com.rodriguesporan.uilists.domain.model.Affirmation
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase
import com.rodriguesporan.uilists.presentation.model.DataView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class CustomDataItemViewModel(
    private val useCase: GetAffirmationsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<DataView>>(emptyList())
    val uiState: StateFlow<List<DataView>> = _uiState.asStateFlow()

    fun getItems() {
        viewModelScope.launch {
            val affirmations: List<Affirmation> = useCase()
            val dataViews: List<DataView> = affirmations.map { affirmation ->
                DataView.DoubleLabel(
                    title = affirmation.title,
                    description = affirmation.description.orEmpty()
                )
            }
            _uiState.emit(dataViews)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val appContainer = (this[APPLICATION_KEY] as UiListsApplication).appContainer
                CustomDataItemViewModel(appContainer.getCustomAffirmationsUseCase)
            }
        }
    }
}
