package com.ibrohimapk3.learneasy.app

import android.app.Application
import com.ibrohimapk3.learneasy.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}