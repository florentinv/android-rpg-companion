apply(from = "${project.rootDir}/gradle/android_shared.gradle")
apply(from = "${project.rootDir}/gradle/koin.gradle")
apply(from = "${project.rootDir}/gradle/unit_test.gradle")

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin)
    id("kotlin-parcelize")
}

android {
    namespace = "com.fvanaldewereld.rpgcompanion.mockFactory"

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    // Implementations - Modules
    implementation(project(":common"))
    implementation(project(":scenario:scenario-data"))

    // Implementations - Google
    implementation(libs.google.api.services.docs)

    // API - Modules
    api(project(":scenario:scenario-domain-api"))
}
