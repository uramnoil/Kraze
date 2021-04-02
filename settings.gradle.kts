pluginManagement {
    val kotlin_version: String by settings
    val dokka_version: String by settings

    repositories {
        gradlePluginPortal()
        mavenCentral()
        jcenter()
    }

    plugins {
        kotlin("multiplatform") version kotlin_version
        id("org.jetbrains.dokka") version dokka_version
    }
}

rootProject.name = "Kraze"

include(":api:shared", ":api")