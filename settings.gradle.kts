pluginManagement {
    val kotlin_version: String by settings

    repositories {
        mavenCentral()
    }

    plugins {
        kotlin("multiplatform") version kotlin_version
    }
}

rootProject.name = "Kraze"

include(":api:shared", ":api")