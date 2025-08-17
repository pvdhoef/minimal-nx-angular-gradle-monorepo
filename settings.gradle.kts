rootProject.name = "minimal-nx-angular-gradle-monorepo"

dependencyResolutionManagement {

    repositories {
        mavenCentral()
    }
}

pluginManagement {

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    includeBuild("build-logic")
}

include(":demoapp-server")
project(":demoapp-server").projectDir = file("apps/demoapp/server")

include(":kotlin-demolib")
project(":kotlin-demolib").projectDir = file("libs/kotlin/demolib")
