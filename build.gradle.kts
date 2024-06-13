buildscript{
    repositories{
        google()
        mavenCentral()
    }
    dependencies{
        classpath(Dependencies.hiltAgp)
        classpath (Dependencies.realm)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    }
}