
println("Configuring '${name}' application...")

group = "com.pvdhoef"
version = "0.0.1-SNAPSHOT"

plugins {
    id("com.pvdhoef.gradle.plugins.conventions.kotlin-conventions")
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.kotlin.allopen)
}

dependencies {

    implementation(project(":kotlin-demolib"))
    implementation(libs.spring.boot.starter.web)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

// TODO: This should probably be moved to the Kotlin conventions plugin.
// tasks.withType<Test> {
//     useJUnitPlatform()
// }
