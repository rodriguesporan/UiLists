package com.rodriguesporan.uilists.di.factories

import androidx.lifecycle.ViewModelProvider

internal interface ViewModelFactory {
    fun create(): ViewModelProvider.Factory
}
