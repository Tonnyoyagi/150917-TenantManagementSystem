@file:Suppress("DEPRECATION")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.tenantmanagementsystemgroupa"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.tenantmanagementsystemgroupa"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation("androidx.navigation:navigation-fragment-ktx:2.9.8" )
    implementation("androidx.navigation:navigation-ui-ktx:2.9.8" )
    implementation("androidx.fragment:fragment-ktx:1.8.9" )
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.2")
}



