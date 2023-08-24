package com.adrian.efinal.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.adrian.efinal.data.db.CartaDataBase
import com.adrian.efinal.model.Card
import com.adrian.final.data.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardDetailViewModel(application: Application): AndroidViewModel(application) {
    private val repository: CardRepository
    init {
        val db=CartaDataBase.getDataBase(application)
        repository = CardRepository(db)
    }

    fun addFavorites(card:Card){
        viewModelScope.launch(Dispatchers.IO){
            repository.addCardFavorites(card)
        }

    }
}