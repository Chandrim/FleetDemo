import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins{
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
}
kotlin{
    js(IR){
        moduleName = "webApp"
        browser{
            commonWebpackConfig{
                outputFileName = "webApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                        add(project.rootDir.path + "/common/")
                        add(project.rootDir.path + "/jsApp/")
                    }
                }
            }
            binaries.executable()
        }
    }

    sourceSets{
        commonMain.dependencies{
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(project(":common"))
        }
        commonTest.dependencies{

        }
    }
}

compose.experimental{
    web.application{}
}

