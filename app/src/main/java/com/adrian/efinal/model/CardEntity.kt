package com.adrian.efinal.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "carta")
data class CardEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val race: String,
    val attribute:String,
    var isFavorite: Boolean = false
)

fun CardEntity.toCard(): Card {
    return Card(
        id, name, type, race, attribute, emptyList(), isFavorite
    )
}