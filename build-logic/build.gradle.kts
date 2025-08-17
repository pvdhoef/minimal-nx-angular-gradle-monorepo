
// Maybe it's not such a good idea to store all build output in the main build directory.
// buildDir = file("../build/build-logic")

plugins {
    id("dev.nx.gradle.project-graph") version("0.1.4")
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
