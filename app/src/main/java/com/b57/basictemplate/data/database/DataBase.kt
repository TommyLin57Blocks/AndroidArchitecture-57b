package com.b57.basictemplate.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.b57.basictemplate.data.entities.RoomEntry

@Database(
    entities = [
        RoomEntry::class],
    version = 1
)
abstract class DataBase : RoomDatabase() {
    abstract fun roomDao(): RoomDao
}