package com.example.dude.domain.models

import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

data class Monsters(
    @PrimaryKey
    val uID :ObjectId= ObjectId(),
    @Required
    val monsterName:String,
    val monsterType:String,
    val monsterAttack:Int,
    val monsterDefense:Int,
    val monsterLive :Boolean,
    val monsterStrength :Int
){
    fun isMonsterAlive ():Boolean{
        return monsterDefense < 0
    }
}
