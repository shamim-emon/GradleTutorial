import com.example.gradle.JarCount

plugins {
    id("application")
    id("my-java.base")
}

tasks.register<JarCount>("countJars"){
    group = "My Group"
    description = "Counts!"

    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFiles.set(layout.buildDirectory.file("gen/count.txt"))
}

tasks.register<Zip>("bundle") {
    group = "My Group"
    description = "package it all!"

    from(tasks.jar)
    from(configurations.runtimeClasspath)

    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}

tasks.build{
    dependsOn(tasks.named("bundle"))
}

//a life-cycle task which itself doesn't do anything
//it rather calls other tasks
tasks.register("buildAll"){
    description = "Builds even more!"

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}