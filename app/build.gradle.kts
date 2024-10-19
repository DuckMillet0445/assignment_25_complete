plugins {
    // Android application plugin
    alias(libs.plugins.android.application)
    // Kotlin Android plugin
    alias(libs.plugins.kotlin.android)
    // Kotlin Compose plugin for Jetpack Compose support
    alias(libs.plugins.kotlin.compose)
    // Kotlin Parcelize plugin for Parcelable implementations
    id("kotlin-parcelize")
    // Safe Args plugin for type-safe navigation between fragments
    id("androidx.navigation.safeargs.kotlin")
    // Kotlin KAPT plugin for annotation processing
    id("kotlin-kapt")
    // Dagger Hilt plugin for dependency injection
    id("dagger.hilt.android.plugin")
    // Additional Hilt plugin for Android integration
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.example.assignment_25"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.assignment_25"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true //Enable Jetpack Compose support
        viewBinding = true // Enable View Binding
    }
}


dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // Navigation components
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


// Test dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")


// Debug dependencies
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    // Hilt for Dependency Injection
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")


// Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")


// Kotlin Standard Library
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")


// Gson Converter
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


// Material Design
    implementation(libs.material)


// AndroidX Activity
    implementation("androidx.activity:activity-ktx:1.9.2")


// AndroidX ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


// Unit testing dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    // AppCompat and RecyclerView
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation(libs.androidx.recyclerview)
}
