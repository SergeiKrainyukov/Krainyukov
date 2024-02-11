plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.sergeikrainyukov.myfavoritefilms"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sergeikrainyukov.myfavoritefilms"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //Core
    val core_ktx = "1.12.0"
    val appcompat = "1.6.1"
    val material = "1.9.0"
    val constraintlayout = "2.1.4"
    val fragment_ktx = "1.6.2"

    //Lifecycle
    val lifecycle = "2.6.2"

    //Retrofit
    val retrofit = "2.9.0"
    val ok_http = "4.9.3"

    //Dagger
    val dagger = "2.46.1"
    val dagger_compiler = "2.42"

    //Room
    val room = "2.6.0"

    //Glide
    val glide = "4.15.1"
    val glide_compiler = "4.12.0"

    //Testing
    val junit = "4.13.2"
    val android_junit = "1.1.5"
    val espresso_core = "3.5.1"


    implementation("androidx.core:core-ktx:$core_ktx")
    implementation("androidx.appcompat:appcompat:$appcompat")
    implementation("com.google.android.material:material:$material")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayout")
    implementation("androidx.fragment:fragment-ktx:$fragment_ktx")


    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofit")
    implementation("com.squareup.okhttp3:okhttp:$ok_http")
    implementation("com.squareup.okhttp3:logging-interceptor:$ok_http")

    //Room
    implementation("androidx.room:room-runtime:$room")
    kapt("androidx.room:room-compiler:$room")

    //Dagger
    implementation("com.google.dagger:dagger:$dagger")
    kapt("com.google.dagger:dagger-compiler:$dagger")

    //Glide
    implementation("com.github.bumptech.glide:glide:$glide")
    annotationProcessor("com.github.bumptech.glide:compiler:$glide_compiler")

    //Testing
    testImplementation("junit:junit:$junit")
    androidTestImplementation("androidx.test.ext:junit:$android_junit")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espresso_core")
}