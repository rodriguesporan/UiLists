package com.rodriguesporan.uilists

import android.app.Application
import com.rodriguesporan.uilists.di.AppContainer

internal class UiListsApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(context = this)
    }
}
