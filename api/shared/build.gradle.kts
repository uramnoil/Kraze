plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

kotlin {
    jvm {}

    sourceSets {
        val commonMain by getting {

        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
            }
        }
    }
}