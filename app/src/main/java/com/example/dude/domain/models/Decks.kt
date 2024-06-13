package com.example.dude.domain.models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId


data class Decks(
    @PrimaryKey
    val dID:ObjectId = ObjectId(),
    @Required
    val deckName:String,
    val deckTypes:String,
    var deckQuantity : List<Cards>,
){
    fun isDeckFull():Boolean{
        return deckQuantity.size < 20
    }
}
