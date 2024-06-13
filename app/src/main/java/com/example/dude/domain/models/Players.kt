package com.example.dude.domain.models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId


open  class Players(
    @PrimaryKey
    val string: ObjectId= ObjectId(),
    @Required
    var id:String,
    var name:String,
    var age:Int,
    val deckOfMonsters : List<Decks>)
