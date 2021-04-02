group = "com.uramnoil.kraze.api"

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

dependencies {
    dokkaHtmlPlugin("org.jetbrains.dokka:kot")
}

kotlin {
    jvm {}

    sourceSets {
        val commonMain by getting {

        }
    }
}
