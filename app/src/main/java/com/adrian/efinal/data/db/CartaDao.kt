package com.adrian.efinal.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.adrian.efinal.model.CardEntity

@Dao
interface CartaDao {

    @Insert
    suspend fun addCardFavorite(card: CardEntity)

    @Query("Select * from carta")
    suspend fun getFavorites() : List<CardEntity>
}