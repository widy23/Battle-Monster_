import Dependencies.appCompat
import Dependencies.coroutines
import Dependencies.espressoCore
import Dependencies.extJunit
import Dependencies.glide
import Dependencies.gson
import Dependencies.hilt
import Dependencies.hiltCompiler
import Dependencies.junit
import Dependencies.kotlinCore
import Dependencies.kspVersion
import Dependencies.lifeCycle
import Dependencies.logginInterceptor
import Dependencies.material
import Dependencies.mongo
import Dependencies.navigationFragment
import Dependencies.navigationUI
import Dependencies.okHttp
import Dependencies.realm
import Dependencies.realmDB
import Dependencies.realmSync
import Dependencies.retrofit
import Dependencies.retrofitConverter
import Dependencies.room
import Dependencies.roomKTX
import Dependencies.shimmer
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    /** General **/

    const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val material = "com.google.android.material:material:${Versions.material}"

    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    val lifeCycleComp by lazy { "androidx.lifecycle:lifecycle-compiler:${Versions.lifeCycle}" }

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    const val shimmer= "com.facebook.shimmer:shimmer:${Versions.shimmer}"

    /** data base **/


    const val room = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomKTX = "androidx.room:room-ktx:${Versions.room_version}"
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room_version}" }
    val realm by lazy {  "io.realm:realm-gradle-plugin:10.15.1"  }
    const val mongo ="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.mongodb}"
    const val realmSync ="io.realm.kotlin:library-sync:${Versions.realmDb}"
    const val realmDB ="io.realm.kotlin:library-base:${Versions.realmDb}"

    /** Testing **/

    const val junit = "junit:junit:${Versions.junit}"

    const val extJunit = "androidx.ext.test.ext:junit:${Versions.extJunit}"

    const val espressoCore = "androidx.ext.test.espresso:espresso-core:${Versions.espresso}"
    /** Network **/

    val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }

    val okHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }

    val retrofitConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}" }

    val logginInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}" }

    /** DI **/
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAgp by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }

    /** KSP**/
     val kspVersion by lazy { "com.google.dagger:dagger-compiler:${Versions.ksp}" }

    /** Navigation **/

    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }

    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }

}
/** Dependencies **/

fun DependencyHandler.general() {
    implementation(material)
    implementation(appCompat)
    implementation(coroutines)
    implementation(kotlinCore)
    implementation(glide)
    implementation(shimmer)


}

fun DependencyHandler.lifecycle(){
    implementation(lifeCycle)
}

fun DependencyHandler.ksp(){
    kapt(hiltCompiler)
}
fun DependencyHandler.room(){
    implementation(room)
    implementation(roomKTX)
    kapt(kspVersion)
}

fun DependencyHandler.mongodb(){
    implementation(mongo)
    implementation(realmDB)
    implementation(realm)
    implementation(realmSync)
}

fun DependencyHandler.testing() {
    testImplementation(junit)
    androidTestImplementation(extJunit)
    androidTestImplementation(espressoCore)

}

fun DependencyHandler.network() {
    implementation(gson)
    implementation(okHttp)
    implementation(retrofit)
    implementation(logginInterceptor)
    implementation(retrofitConverter)

}

fun DependencyHandler.di() {
    kapt(kspVersion)
    implementation(hilt)

}

fun DependencyHandler.navigation() {
    implementation(navigationUI)
    implementation(navigationFragment)

}