package com.rodriguesporan.uilists.di.factories

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.application.UiListsApplication
import com.rodriguesporan.uilists.presentation.view.custom.CustomDataViewModel

internal object CustomDataViewModelFactory: ViewModelFactory {
    override fun create(): ViewModelProvider.Factory = viewModelFactory {
        initializer {
            val appContainer = (this[APPLICATION_KEY] as UiListsApplication).appContainer
            CustomDataViewModel(appContainer.getCustomAffirmationsUseCase)
        }
    }
}