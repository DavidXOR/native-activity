plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.cloudycode.native_activity"
    compileSdk = 34
    ndkVersion = "26.1.10909125"

    defaultConfig {
        applicationId = "com.cloudycode.native_activity"
        minSdk = 24
        targetSdk = 30
        versionCode = 1
        versionName = "Beta"

        externalNativeBuild {
            cmake {
                arguments("-DANDROID_STL=c++_static")
            }
        }
    }

    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
            version = "3.28.0-rc3"
        }
    }
}

dependencies {
    implementation(files(fileTree("libs") { include("*.jar") }))
}