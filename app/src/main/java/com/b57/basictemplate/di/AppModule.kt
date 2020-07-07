package com.b57.basictemplate.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single {
        androidApplication().assets
    }
}