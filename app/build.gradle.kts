apply(from = "${project.rootDir}/gradle/ktlint.gradle")
apply(from = "${project.rootDir}/gradle/compose.gradle")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrain.kotlin)
}

android {
    namespace = "com.fvanaldewereld.rpgcompanion"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.fvanaldewereld.rpgcompanion"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.runtime.ktx)

    testImplementation(libs.junit.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)

    // Koin
    implementation(libs.koin.android)
    testImplementation(libs.koin.test.junit4)
}
