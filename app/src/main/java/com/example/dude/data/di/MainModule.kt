package com.example.dude.data.di

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.dude.data.DB.DatabaseModule
import com.example.dude.domain.models.Decks
import com.example.network_config.core.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bson.types.ObjectId
import javax.inject.Singleton

private const val TAG = "DATABASE_TAG"

@HiltAndroidApp
@Module
@InstallIn(SingletonComponent::class)
class MainModule :Application() {


    companion object{
        lateinit var realm :Realm
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        realm= Realm.getDefaultInstance()
        checkInternetConnection()
        initDB()
        DatabaseModule.providesRealDataBase(this)
        initiateDatabase()
        CoroutineScope(Dispatchers.Main).launch {
            createOrOpenDeckDB()
        }
    }

    private fun initDB() {
        val uri = "mongodb+srv://widyb88:0DWZLBUYvA1ahBgl@monster.xnbrzgi.mongodb.net/?retryWrites=true&w=majority&appName=Monster"
     //   val mongoClient = MongoClient.create(uri)
//        val database = mongoClient.getDatabase("battle_monster")
//        val collection = database.getCollection<Document>("cards")
//
//        mongoClient.close()
    }

    private  fun createOrOpenDeckDB() {
        val  realm= initiateDatabase()
        val modelClasses = realm.configuration.realmObjectClasses.equals("Decks")
        Log.d(TAG,modelClasses.toString())
        if (!modelClasses){
            createTableOfDecks()
        }
//        if (!modelClasses){
//            realm.executeTransaction { transactionRealm ->
//                createListOfDecks().forEach { user ->
//                    transactionRealm.insertOrUpdate(user)
//                }
//            }
//            val savedObject = realm.where(Decks::class.java).findAll()
//            if (savedObject != null) {
//            savedObject.forEach {
//                Log.d("RealmDatabase", "New table created: ${it.deckName}")
//                                }
//            } else {
//                Log.d("RealmDatabase", "Something wrong happened.")
//            }
//        }else{
//            withContext(Dispatchers.Main) {
//                val savedUsers = realm.where<Decks>().findAll()
//                savedUsers.forEach {
//                    Log.d("RealmDatabase", "User: ${it.deckName}, Age: ${it.deckTypes}, Deck: ${it.deckQuantity}")
//                }
//            }
//        }


    }

    private fun createTableOfDecks() {
        val realm = initiateDatabase()
        realm.executeTransaction{
            it.copyToRealmOrUpdate(createListOfDecks())
        }
        Log.d(TAG,"Item Add")


    }

    private fun createListOfDecks(): List<Decks> {
        val deck1 = Decks(ObjectId.get(), "Life", "WATER", Decks().deckQuantity)
        val deck2 = Decks(ObjectId.get(), "Pyro", "FIRE", Decks().deckQuantity)
        val deck3 = Decks(ObjectId.get(), "Health", "WOOD", Decks().deckQuantity)
        return listOf(deck1, deck2, deck3)
    }


    @Provides
    @Singleton
     fun initiateDatabase() :Realm {
       return DatabaseModule.providesRealmInstance()
    }

    private fun checkInternetConnection() {
        if (NetworkHelper.checkNetworkConnection(this)) {
            Toast.makeText(this, "have connection", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "do not have connection.. retry ", Toast.LENGTH_SHORT).show()
        }
    }

}