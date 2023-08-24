package com.adrian.efinal.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl("https://db.ygoprodeck.com/api/v7/").addConverterFactory(
            GsonConverterFactory.create()).build()
    val cardService: CardService = retrofit.create(CardService::class.java)

}
