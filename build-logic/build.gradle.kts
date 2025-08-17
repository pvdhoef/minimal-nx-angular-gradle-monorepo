
// Maybe it's not such a good idea to store all build output in the main build directory.
// buildDir = file("../build/build-logic")

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("KotlinConventionPlugin") {
            id = "com.pvdhoef.gradle.plugins.conventions.kotlin-conventions"
            implementationClass = "com.pvdhoef.gradle.plugins.conventions.KotlinConventionPlugin"
        }
    }
}
