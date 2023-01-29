package com.example.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFiles;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

//@CacheableTask
public abstract class JarCount extends DefaultTask {

    //ConfigurableFileCollection <- @InputFiles
    //RegularFileProperty <- @InputFiles
    //DirectoryProperty <- @InputDirectory

    @InputFiles
    public abstract ConfigurableFileCollection getAllJars();

    @OutputFiles
    public abstract RegularFileProperty getCountFiles();

    @TaskAction
    public void doCount(){
        Set<File> jarFile = getAllJars().getFiles();
        int count = jarFile.size();
        File out =getCountFiles().get().getAsFile();
        try {
            Files.write(out.toPath(), Collections.singleton(""+ count));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
