plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {

    /**
     * The app's namespace. Used primarily to access app resources.
     */

    namespace = "com.example.fleetdemo"

    /**
     * compileSdk specifies the Android API level Gradle should use to
     * compile your app. This means your app can use the API features included in
     * this API level and lower.
     */

    compileSdk = 34

    /**
     * The defaultConfig block encapsulates default settings and entries for all
     * build variants and can override some attributes in main/AndroidManifest.xml
     * dynamically from the build system. You can configure product flavors to override
     * these values for different versions of your app.
     */

    defaultConfig {

        // Uniquely identifies the package for publishing.
        applicationId = "com.example.fleetdemo"

        // Defines the minimum API level required to run the app.
        minSdk = 24
        targetSdk = 34

        // Defines the version number of your app.
        versionCode = 1

        // Defines a user-friendly version name for your app.
        versionName = "1.0"
    }

    buildTypes {

        /**
         * By default, Android Studio configures the release build type to enable code
         * shrinking, using minifyEnabled, and specifies the default ProGuard rules file.
         */

        getByName("release") {
            isMinifyEnabled = true // Enables code shrinking for the release build type.
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures{
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    dependencies {
        val composeBom = platform(libs.androidx.compose.bom)
        implementation(composeBom)
        androidTestImplementation(composeBom)
        implementation(libs.androidx.activity.compose)
        debugImplementation(libs.compose.ui.tooling)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.compose.material3)
        implementation(libs.compose.ui.tooling.preview)
        implementation(project(":common"))
    }
}



