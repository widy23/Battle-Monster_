package com.example.dude.data.di

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.dude.data.DB.DatabaseModule
import com.example.network_config.core.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import javax.inject.Singleton

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
        createOrOpenDeckDB()
        checkInternetConnection()
        DatabaseModule.providesRealDataBase(this)
        initiateDatabase()
    }

    private fun createOrOpenDeckDB() {

    }


    @Provides
    @Singleton
     fun initiateDatabase() :Realm {
       return DatabaseModule.providesRealmInstance()
    }

    private fun checkInternetConnection() {
        if (NetworkHelper.checkNetworkConnection(this)) {
            Toast.makeText(this, "have connection", Toast.LENGTH_SHORT).show()

            Log.v("New Example Realm 4","Successfully opened the default realm at: ${realm.path}")
        } else {
            Toast.makeText(this, "do not have connection.. retry ", Toast.LENGTH_SHORT).show()
            //viewModel.getNewsFromDataBase()
        }
    }

}