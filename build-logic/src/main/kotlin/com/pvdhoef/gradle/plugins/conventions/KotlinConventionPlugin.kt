package com.pvdhoef.gradle.plugins.conventions

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class KotlinConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        println("Applying Kotlin conventions to project: '${project.name}'")

        // Apply the Kotlin JVM plugin.
        // Aka `kotlin("jvm")`.
        // Aka `alias(libs.plugins.kotlin.jvm)`
        // The `alias` syntax can't be used here, so the string ID used. And the version cannot be specified either.
        // The root project applies the correct version via `plugins { alias(libs.plugins.kotlin.jvm) apply false }`.
        project.pluginManager.apply("org.jetbrains.kotlin.jvm")

        // This is similar to the `java { toolchain { ... } ... etc. }` DSL in `build.gradle.kts`.
        project.extensions.configure<JavaPluginExtension> {
            toolchain.languageVersion.set(JavaLanguageVersion.of(21))
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }

        // This is similar to the `kotlin { jvmToolchain(21) ... etc. }` DSL in `build.gradle.kts`.
        project.extensions.configure<KotlinJvmProjectExtension> {
            jvmToolchain(21)
            compilerOptions {
                freeCompilerArgs.add("-Xjsr305=strict")
            }
        }

        // project.repositories {
        //     mavenCentral()
        // }
    }
}
