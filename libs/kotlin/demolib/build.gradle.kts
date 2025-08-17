println("Configuring '${name}' library...")

group = "com.pvdhoef"
version = "0.0.1-SNAPSHOT"

plugins {
    alias(libs.plugins.nx.gradle.plugin)
    id("com.pvdhoef.gradle.plugins.conventions.kotlin-conventions")
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.dependency.management)
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.spring.boot.starter)
}
