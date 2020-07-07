package com.b57.basictemplate.ui.room.edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.b57.basictemplate.data.entities.RoomEntry
import com.b57.basictemplate.domain.room.SaveRoomEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryEditViewModel(
    private val saveRoomEntry: SaveRoomEntry
) : ViewModel() {

    val content = MutableLiveData<String>()

    fun save() {
        viewModelScope.launch(Dispatchers.IO) {
            saveRoomEntry(RoomEntry(content = content.value))
            content.postValue(null)
        }
    }

}