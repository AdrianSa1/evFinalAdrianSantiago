package com.adrian.final.data.repository


import android.provider.ContactsContract.CommonDataKinds.Note
import com.adrian.efinal.data.db.CartaDao
import com.adrian.efinal.data.db.CartaDataBase
import com.adrian.efinal.data.repository.CardServiceResult
import com.adrian.efinal.data.response.ListCardResponse
import com.adrian.efinal.data.retrofit.RetrofitHelper
import com.adrian.efinal.model.Card
import com.adrian.efinal.model.toCard
import com.adrian.efinal.model.toCardEntity

class CardRepository(val db: CartaDataBase? =null) {

    private val dao: CartaDao? = db?.cartaDao()

    suspend fun getCards(): CardServiceResult<ListCardResponse> {
        return try {
            val response = RetrofitHelper.cardService.getAllNotes()
            CardServiceResult.Success(response)
        } catch (e: java.lang.Exception) {
            CardServiceResult.Error(e)
        }
    }

    suspend fun  getFavorites() : List<Card>{
        dao?.let {
            val data = dao.getFavorites()
            val cards: MutableList<Card> = mutableListOf()
            for (cardEntity in data){
                cards.add(cardEntity.toCard())
            }
            return cards
        } ?: kotlin.run {
            return listOf()
        }
    }

    suspend fun addCardFavorites(card: Card){
        dao?.let {
            dao.addCardFavorite(card.toCardEntity())
        }
    }

}
