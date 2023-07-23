package com.rodriguesporan.uilists.di

import com.rodriguesporan.uilists.data.CustomDataItemDatasource
import com.rodriguesporan.uilists.data.SimpleDataItemDatasource

internal class AppContainer {
    val simpleDataItemDatasource = SimpleDataItemDatasource()
    val customDataItemDatasource = CustomDataItemDatasource()
}
