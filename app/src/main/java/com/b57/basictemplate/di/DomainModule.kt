package com.b57.basictemplate.di

import com.b57.basictemplate.domain.LoginByPasswordUseCase
import com.b57.basictemplate.domain.ObserveRoomEntities
import com.b57.basictemplate.domain.SaveRoomEntry
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

}