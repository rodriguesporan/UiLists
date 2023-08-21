package com.rodriguesporan.uilists.di.factories

internal interface Factory<T> {
    fun create(): T
}
