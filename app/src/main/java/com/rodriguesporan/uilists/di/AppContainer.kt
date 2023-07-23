package com.rodriguesporan.uilists.di

import com.rodriguesporan.uilists.data.datasource.CustomAffirmationDatasource
import com.rodriguesporan.uilists.data.datasource.SimpleAffirmationDatasource
import com.rodriguesporan.uilists.data.repository.AffirmationRepositoryImpl
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase

internal class AppContainer {
    private val _simpleDataItemDatasource = SimpleAffirmationDatasource()
    private val _customAffirmationDatasource = CustomAffirmationDatasource()
    val getSimpleAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(_simpleDataItemDatasource))
    val getCustomAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(_customAffirmationDatasource))
}
