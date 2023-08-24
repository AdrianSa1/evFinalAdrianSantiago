package com.adrian.efinal.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrian.efinal.data.repository.CardServiceResult
import com.adrian.efinal.model.Card
import com.adrian.final.data.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardListViewModel: ViewModel() {

    val notes: MutableLiveData<List<Card>> = MutableLiveData<List<Card>>()
    val repository = CardRepository()

    /*
    fun getAllNotes() {
        val noteList = getData()
        notes.value = noteList
    }*/

    fun getNotesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCards()
            when(response) {
                is CardServiceResult.Success -> {
                    notes.postValue(response.data.data)
                }
                is CardServiceResult.Error -> {
                    //
                }
            }
        }
    }

}