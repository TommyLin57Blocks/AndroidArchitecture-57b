package com.b57.basictemplate.domain

import androidx.lifecycle.LiveData
import com.b57.basictemplate.data.database.RoomDao
import com.b57.basictemplate.data.entities.RoomEntry

class ObserveRoomEntities(
    private val roomDao: RoomDao
) {

    operator fun invoke() : LiveData<List<RoomEntry>> {
        return roomDao.observeEntities()
    }
}