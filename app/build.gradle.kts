apply(from = "${project.rootDir}/gradle/ktlint.gradle")
apply(from = "${project.rootDir}/gradle/compose.gradle")
apply(from = "${project.rootDir}/gradle/kover.gradle")
apply(from = "${project.rootDir}/gradle/sonarqube.gradle")
apply(plugin = "kotlin-parcelize")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.jetbrains.kotlinx.kover)
    alias(libs.plugins.sonarqube)
}

android {
    namespace = "com.fvanaldewereld.rpgcompanion"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fvanaldewereld.rpgcompanion"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,DEPENDENCIES,LICENSE,LICENSE.txt,license.txt,NOTICE,NOTICE.txt,*.kotlin_module}"
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    // Androidx
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    // Google
    implementation(libs.google.api.services.docs)
    implementation(libs.google.auth.library.oauth2.http)

    // Okhttp3
    implementation(libs.okhttp3.okhttp)
    implementation(libs.okhttp3.logging)

    // Retrofit2
    implementation(libs.retrofit2.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)

    // Test
    testImplementation(libs.koin.junit5)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.jupiter.api)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockk)

    testRuntimeOnly(libs.junit.jupiter.engine)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
}
