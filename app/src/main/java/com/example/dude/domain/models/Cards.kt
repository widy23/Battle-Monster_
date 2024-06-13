package com.example.dude.domain.models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

data class Cards(
    @PrimaryKey
    val idCard :ObjectId = ObjectId(),
    @Required
    val type :Monsters,
    val name :Monsters,
    val attack: Monsters,
    val defence :Monsters,
    val image:String,
    var status: String ?
){
    fun isCanFight() :Boolean{
        return attack.monsterAttack < 50
    }
}
