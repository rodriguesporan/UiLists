package com.rodriguesporan.uilists.di.factories.viewmodel

import androidx.lifecycle.ViewModelProvider

internal interface ViewModelFactory {
    fun create(): ViewModelProvider.Factory
}
