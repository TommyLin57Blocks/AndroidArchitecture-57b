package com.b57.basictemplate.di

import androidx.room.Room
import com.b57.basictemplate.ui.contact.list.ListViewModel
import com.b57.basictemplate.ui.login.LoginViewModel
import com.b57.basictemplate.data.database.DataBase
import com.b57.basictemplate.ui.okhttp.HttpDemoViewModel
import com.b57.basictemplate.ui.recycler_bind.RecyclerViewModel
import com.b57.basictemplate.ui.room.EntryEditViewModel
import com.b57.basictemplate.ui.room.EntryListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        LoginViewModel(
            loginByPwd = get()
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