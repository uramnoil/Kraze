pluginManagement {
    val kotlinVersion: String by settings

    repositories {
        mavenCentral()
    }

    plugins {
        kotlin("multiplatform") version kotlinVersion
    }
}

rootProject.name = "Kraze"

include(":api")
