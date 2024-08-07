package com.example.dude.domain.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required
import org.bson.types.ObjectId

@RealmClass
open class Decks(
    @PrimaryKey
    var _dID : ObjectId = ObjectId(),
    @Required
    var deckName:String="",
    var deckTypes:String="",
    var deckQuantity : Int=20,
):RealmObject(){
    fun isDeckFull():Boolean{
        return deckQuantity < 20
    }
}
