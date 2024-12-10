// build.gradle.kts (Módulo: app)
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(34)

    // Especifica el namespace (ID del paquete) de tu aplicación
    namespace = "com.example.gealth"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17

        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }

    defaultConfig {
        applicationId = "com.example.gealth"
        minSdkVersion(21)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // Habilitar ViewBinding
    viewBinding {
    }
}

dependencies {
    // Dependencias necesarias para tu aplicación
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
}
