package com.b57.basictemplate.di

import androidx.room.Room
import com.b57.basictemplate.data.database.DataBase
import com.b57.basictemplate.data.repository.LoginRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    factory {
        LoginRepository()
    }

    single {
        Room.databaseBuilder(androidApplication(), DataBase::class.java, "sample.db")
            .build()
    }

    single {
        get<DataBase>().roomDao()
    }

}