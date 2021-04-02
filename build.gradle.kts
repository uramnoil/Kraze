group = "com.uramnoil.kraze"
version = "0.1.0"

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        val kotlin_version: String by project

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}
