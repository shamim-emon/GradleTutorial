pluginManagement {
    repositories.gradlePluginPortal()
    //repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://my.localtion/repo"){
//        credentials.username ="...."
//        credentials.password ="...."
//    }
//
    includeBuild("gradle/plugins")
}
dependencyResolutionManagement {
    repositories.mavenCentral()
//    repositories.google()
//    repositories.maven("https://my.localtion/repo"){
//        credentials.username ="...."
//        credentials.password ="...."
//    }
//
//    includeBuild("../my-other-project")
}

rootProject.name = "GradleTutorial"

include("app")
include("business-logic")
include("data-model")