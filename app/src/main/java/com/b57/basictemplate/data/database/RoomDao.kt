package com.b57.basictemplate.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.b57.basictemplate.data.entities.RoomEntry

@Dao
abstract class RoomDao {

    @Query("SELECT * FROM room_entry")
    abstract fun observeEntities() : LiveData<List<RoomEntry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun saveEntry(entry: RoomEntry)

}