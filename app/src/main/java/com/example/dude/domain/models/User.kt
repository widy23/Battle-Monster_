package com.example.dude.domain.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class User(
 @PrimaryKey
 var _id: ObjectId = ObjectId(),
 @Required
  var name: String = "",
 var age: Int = 0,
 var adult: Boolean = false,
 var deckOfMonsters: Int = 0,
): RealmObject()
