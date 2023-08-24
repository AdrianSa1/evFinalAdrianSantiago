package com.adrian.efinal.data.retrofit

import com.adrian.efinal.data.response.ListCardResponse
import retrofit2.http.GET

interface CardService {

    @GET("cardinfo.php?cardset=metal%20raiders&num=5&offset=0")
    suspend fun getAllNotes(): ListCardResponse

}