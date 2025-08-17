// This project is *not* part of the main monorepo Gradle project.
rootProject.name = "build-logic"

// But it *does* use the version catalog of the main project so all versions of the whole monorepo are in sync.
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
