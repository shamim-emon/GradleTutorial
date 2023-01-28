plugins {
    id("my-application")
}

application{
    mainClass.set("com.example.MyApplication")
}

dependencies{
    implementation(project(":business-logic"))
    implementation(project(":data-model"))
}