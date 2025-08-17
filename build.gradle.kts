// Main build file.

/*
    The `build-logic` project depends on "org.jetbrains.kotlin:kotlin-gradle-plugin" as a library.
    That means it pulls the plugin classes into its classpath.

    Other projects also apply the Kotlin Gradle plugin indirectly via `plugins { id("org.jetbrains.kotlin.jvm") ... }`.
    This results in Gradle loading the same plugin again into a different classloader.

    The warning message is:

        The Kotlin Gradle plugin was loaded multiple times in different subprojects,
        which is not supported and may break the build.

        Please add the Kotlin plugin to the common parent project or the root project, then remove the versions
        in the subprojects. If the parent project does not need the plugin, add 'apply false' to the plugin line.

    To prevent this, the plugins that may be loaded via convention plugins are declared below with `apply false`.
    Thus will also make sure that their versions are pinned down according to the version catalog.
*/

plugins {

    alias(libs.plugins.kotlin.jvm) apply false
}
