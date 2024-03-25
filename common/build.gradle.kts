plugins {
    alias(libs.plugins.jetbrainsCompose) // Plugins for jetbrains compose for common UI
    alias(libs.plugins.kotlinMultiplatform) // Plugins for kotlin multiplatform
    alias(libs.plugins.androidLibrary) // Plugins for android

}
kotlin{
    androidTarget() //Define android target
    js(IR) { // Define js target
        browser{
            binaries.executable()
        }
    }
    sourceSets{
        commonMain.dependencies{
        //Declare dependencies for common target
        }
        jsMain.dependencies{
        //Declare dependencies for js specific target for common module
        }

        commonTest.dependencies {
        //Declare dependencies for test for common module
        }
        jsTest.dependencies {
        //Declare dependencies for js test for common module
        }
        androidMain.dependencies {
        //Declare dependencies for js specific target common module
        }
        androidNativeTest.dependencies {
        //Declare dependencies for android unit test for common module
        }
    }
}

android{
    //Declare android target specific code
    namespace = "com.example.fleetdemo"
    compileSdk = 34
    defaultConfig{
        minSdk = 24
        testOptions.targetSdk = 34
    }
    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
}



