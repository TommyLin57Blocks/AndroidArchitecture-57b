package com.b57.basictemplate.ui.room

import androidx.lifecycle.ViewModel
import com.b57.basictemplate.domain.ObserveRoomEntities

class EntryListViewModel(
    private val observeRoomEntities: ObserveRoomEntities
) : ViewModel() {

    val entryList = observeRoomEntities()

}