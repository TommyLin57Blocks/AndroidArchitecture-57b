package com.b57.basictemplate.di

import com.b57.basictemplate.domain.okhttp.FetchContactByNetwork
import com.b57.basictemplate.domain.login.LoginByPasswordUseCase
import com.b57.basictemplate.domain.room.ObserveRoomEntities
import com.b57.basictemplate.domain.room.SaveRoomEntry
import org.koin.dsl.module

val domainModule = module {

    factory {
        LoginByPasswordUseCase(
            loginRepository = get()
        )
    }

    factory {
        ObserveRoomEntities(
            roomDao = get()
        )
    }

    factory {
        SaveRoomEntry(
            roomDao = get()
        )
    }

    factory {
        FetchContactByNetwork(
            testApi = get()
        )
    }

}