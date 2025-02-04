plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Android.compileSdkVersion)
    buildToolsVersion(Android.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Android.minSdkVersion)
        targetSdkVersion(Android.targetSdkVersion)
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets["main"].java.srcDir("src/main/kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlinStdlib)
    implementation(Libs.Retrofit.moshiConverter)
    implementation(Libs.Retrofit.rxAdapter)
    implementation(Libs.okHttp)
    implementation(Libs.Rx.android)

    api(Libs.Retrofit.retrofit)
    api(Libs.Dagger.core)

    kapt(Libs.Dagger.compiler)
}
