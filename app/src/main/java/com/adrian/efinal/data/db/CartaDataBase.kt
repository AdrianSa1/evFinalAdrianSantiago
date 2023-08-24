package com.adrian.efinal.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adrian.efinal.model.CardEntity

@Database(entities = [CardEntity::class], version = 1)
abstract class CartaDataBase: RoomDatabase() {
    abstract fun cartaDao(): CartaDao

    companion object{
        @Volatile
        private var instace: CartaDataBase?=null
        fun getDataBase(context: Context):CartaDataBase{
            val tempIntance= instace
            if(tempIntance !=null){
                return tempIntance
            }
            synchronized(this){
                val _instance=Room.databaseBuilder(context.applicationContext, CartaDataBase::class.java,"cartadb").build()
                instace=_instance
                return _instance
            }
        }
    }
}