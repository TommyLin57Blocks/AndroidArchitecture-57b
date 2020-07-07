package com.b57.basictemplate.di

import com.b57.basictemplate.ui.contact.list.ListViewModel
import com.b57.basictemplate.ui.login.LoginViewModel
import com.b57.basictemplate.domain.login.LoginByPasswordUseCase
import com.b57.basictemplate.ui.okhttp.HttpDemoViewModel
import com.b57.basictemplate.ui.recycler_bind.RecyclerViewModel
import com.b57.basictemplate.ui.room.edit.EntryEditViewModel
import com.b57.basictemplate.ui.room.list.EntryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel<LoginViewModel> {
        LoginViewModel(
            loginByPwd = get<LoginByPasswordUseCase>()
        )
    }

    viewModel {
        ListViewModel()
    }

    viewModel {
        EntryListViewModel(
            observeRoomEntities = get()
        )
    }

    viewModel {
        EntryEditViewModel(
            saveRoomEntry = get()
        )
    }

    viewModel {
        RecyclerViewModel()
    }

    viewModel {
        HttpDemoViewModel(
            fetchContactByNetwork = get()
        )
    }
}