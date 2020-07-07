package com.b57.basictemplate.di

import androidx.room.Room
import com.b57.architecture.okhttp.ApiClientFactory
import com.b57.basictemplate.data.api.TestApi
import com.b57.basictemplate.data.database.DataBase
import com.b57.basictemplate.data.repository.ILoginRepository
import com.b57.basictemplate.data.repository.LoginRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    factory<ILoginRepository> {
        LoginRepository()
    }

    single {
        Room.databaseBuilder(androidApplication(), DataBase::class.java, "sample.db")
            .build()
    }

    single {
        get<DataBase>().roomDao()
    }

    single {
        ApiClientFactory.build("http://192.168.180.38:8080", TestApi::class.java)
    }

}