package com.adrian.efinal.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adrian.efinal.data.db.CartaDataBase
import com.adrian.efinal.model.Card
import com.adrian.final.data.repository.CardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardFavoriteViewModel(application: Application):AndroidViewModel(application) {

    private val repository: CardRepository
    private var _favorites: MutableLiveData<List<Card>> = MutableLiveData()
    var favorites: LiveData<List<Card>> = _favorites

    init {
        val db = CartaDataBase.getDataBase(application)
        repository = CardRepository(db)
    }
    fun getFavorites(){
        viewModelScope.launch(Dispatchers.IO){
            val data=repository.getFavorites()
            _favorites.postValue(data)
        }
    }



}