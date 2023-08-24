package com.adrian.efinal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class Card(
    val id: Int,
    val name: String,
    val type: String,
    val race: String,
    val attribute:String,
    val card_images:@RawValue List<CardImage>,
    var isFavorite: Boolean = false

):Parcelable

data class CardImage(
    val image_url: String
)

fun Card.toCardEntity():  CardEntity{
    return CardEntity(
        id, name, type, race, attribute, isFavorite
    )
}

