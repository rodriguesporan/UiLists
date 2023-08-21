package com.rodriguesporan.uilists.di.factories.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rodriguesporan.uilists.application.UiListsApplication
import com.rodriguesporan.uilists.presentation.view.simple.SimpleDataViewModel

internal object SimpleDataViewModelFactory: ViewModelFactory {
    override fun create(): ViewModelProvider.Factory = viewModelFactory {
        initializer {
            val appContainer = (this[APPLICATION_KEY] as UiListsApplication).appContainer
            SimpleDataViewModel(appContainer.getSimpleAffirmationsUseCase)
        }
    }
}
