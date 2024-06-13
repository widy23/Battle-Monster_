import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTestImplementation(library: String) {
    add("androidTestImplementation", library)
}

fun DependencyHandler.kapt(library: String) {
    add("kapt", library)
}

fun DependencyHandler.networkConfig(){
    implementation(project(":Network-Config"))
}