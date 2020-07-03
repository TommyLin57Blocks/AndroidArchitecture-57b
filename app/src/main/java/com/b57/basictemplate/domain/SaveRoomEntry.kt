package com.b57.basictemplate.domain

import com.b57.basictemplate.data.database.RoomDao
import com.b57.basictemplate.data.entities.RoomEntry

class SaveRoomEntry(
    private val roomDao: RoomDao
) {

    suspend operator fun invoke(entry: RoomEntry) {
        roomDao.saveEntry(entry)
    }
}