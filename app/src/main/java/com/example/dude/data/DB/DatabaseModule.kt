package com.example.dude.data.DB

import android.content.Context
import com.example.network_config.core.MainCoreUtils.Companion.USER_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.Realm.getApplicationContext
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

   private lateinit var configuration: RealmConfiguration
    fun providesRealDataBase(@ApplicationContext context: Context)  {
        configuration = RealmConfiguration.Builder()
            .name(USER_DB)
            .schemaVersion(3)
            .allowWritesOnUiThread(true)
            .build()
        val context = getApplicationContext()
        if (!File(configuration.path).exists()) { //DB doesn't exist
            try {
                val inputStream: InputStream = context?.assets?.open(USER_DB)!!
                val outputStream: OutputStream = FileOutputStream(configuration.path)
                inputStream.copyTo(outputStream)
                inputStream.close()
                outputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }

    @Singleton
    @Provides
    fun providesRealmInstance() :Realm{
        setDefaultConfiguration(configuration)
        return Realm.getDefaultInstance()
    }
    class MyMigration : RealmMigration {
        override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
            val schema = realm.schema

            if (oldVersion == 1L) {
                // Ejemplo de cambios en el esquema: añadir un nuevo campo
                schema.get("Item")
                    ?.addField("newField", String::class.java)
                oldVersion + 1L
            }

            // Añade aquí más migraciones si cambias el esquema en el futuro
        }
    }
}