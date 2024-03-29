package com.rodriguesporan.uilists.presentation.view.custom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguesporan.uilists.domain.model.Affirmation
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase
import com.rodriguesporan.uilists.presentation.model.DataView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class CustomDataViewModel(
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
}
