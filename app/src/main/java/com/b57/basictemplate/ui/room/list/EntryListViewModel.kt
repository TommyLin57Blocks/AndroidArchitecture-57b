package com.b57.basictemplate.ui.room.list

import androidx.lifecycle.ViewModel
import com.b57.basictemplate.domain.room.ObserveRoomEntities

class EntryListViewModel(
    private val observeRoomEntities: ObserveRoomEntities
) : ViewModel() {

    val entryList = observeRoomEntities()

}