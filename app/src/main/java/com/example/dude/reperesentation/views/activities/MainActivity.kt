package com.example.dude.reperesentation.views.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.dude.R
import com.example.dude.domain.models.User
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        realm = Realm.getDefaultInstance()
        val databaseName = realm.configuration.realmFileName
        val schema = realm.configuration.realmObjectClasses
        val modelClasses = schema.firstOrNull()?.simpleName
        Log.v("Realm 5","Successfully opened resume realm at: $databaseName")
        Log.v("Realm 5","table name: $modelClasses")
        Log.v("Realm 5","table name: ${modelClasses.isNullOrBlank()}")
        val firstObject = realm.where(User::class.java).findFirst()
        Log.v("Realm 5","name: ${firstObject?.name}")



        // Verifica si hay un usuario existente al iniciar la actividad
        lifecycleScope.launch {
            verifying()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cierra la instancia de Realm al destruir la actividad
        realm.close()
    }

    private fun verifying() {
            // Asegúrate de ejecutar esta operación en el hilo de I/O

                val result =realm.where(User::class.java).findFirst()
                runBlocking {
                    if (result == null || result.name.isBlank()) {
                        Toast.makeText(this@MainActivity, "Create a new User", Toast.LENGTH_SHORT).show()
                        lifecycleScope.launch {
                            addNewUser()
                        }
                    } else {
                        val userName = result.name
                        Toast.makeText(this@MainActivity, "User: $userName", Toast.LENGTH_SHORT).show()
                    }
                }


    }

    private  fun addNewUser() {

            realm.executeTransaction { transactionRealm ->
                val myModel = transactionRealm.createObject(User::class.java, 1) // ID = 1
                myModel.name = "John Doe"
                myModel. age = 30
                myModel. adult = true
                myModel.deckOfMonsters = 2
            }
            val savedObject = realm.where(User::class.java).findFirst()
            if (savedObject != null) {
                Log.d("RealmDatabase", "Objeto guardado: ${savedObject.name}")
            } else {
                Log.d("RealmDatabase", "El objeto no se pudo guardar.")
            }

            // Cerrar la instancia de Realm
            verifying()
            }
               // transactionRealm.insert(user)
            }



