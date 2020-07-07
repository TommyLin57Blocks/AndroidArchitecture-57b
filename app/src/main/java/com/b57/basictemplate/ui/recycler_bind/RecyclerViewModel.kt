package com.b57.basictemplate.ui.recycler_bind

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.b57.basictemplate.data.entities.Contact

class RecyclerViewModel : ViewModel() {

    val contacts = liveData {
        emit((1..30).toList().map {
            Contact(
                "Page 1 Name - $it",
                "Page 1 Phone - $it"
            )
        })
    }
}