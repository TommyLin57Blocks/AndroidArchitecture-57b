package com.b57.basictemplate.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_entry")
data class RoomEntry(
    @PrimaryKey(autoGenerate = true)
    val id : Long ?= null,
    val content: String? = null
)