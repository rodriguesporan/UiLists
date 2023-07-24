package com.rodriguesporan.uilists.di

import com.rodriguesporan.uilists.data.datasource.CustomAffirmationDataSource
import com.rodriguesporan.uilists.data.datasource.SimpleAffirmationDataSource
import com.rodriguesporan.uilists.data.repository.AffirmationRepositoryImpl
import com.rodriguesporan.uilists.domain.usecase.GetAffirmationsUseCase

internal class AppContainer {
    private val _simpleDataItemDatasource = SimpleAffirmationDataSource()
    private val _customAffirmationDatasource = CustomAffirmationDataSource()
    val getSimpleAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(_simpleDataItemDatasource))
    val getCustomAffirmationsUseCase =
        GetAffirmationsUseCase(AffirmationRepositoryImpl(_customAffirmationDatasource))
}
