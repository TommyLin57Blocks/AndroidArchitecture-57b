package com.b57.basictemplate

import android.app.Application
import com.b57.basictemplate.di.dataModule
import com.b57.basictemplate.di.domainModule
import com.b57.architecture.log.ErrorDebugTree
import com.b57.basictemplate.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class B57App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree(),
            ErrorDebugTree()
        )
        startKoin {
            androidContext(this@B57App)
            modules(
                dataModule,
                domainModule,
                uiModule
            )
        }
    }
}