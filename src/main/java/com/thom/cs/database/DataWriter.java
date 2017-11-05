package com.thom.cs.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DataWriter {
    public DataReader dr = new DataReader();

    /**
     * Creates a directory with the given name inside the "dbs" directory.
     *
     * @param directoryName The name for the directory
     */
    public void createDatabaseDirectory(String directoryName) {
        new File("./dbs/" + directoryName).mkdir();
        System.out.println("Directory created at: ./dbs/" + directoryName);
    }

    /**
     * Creates a directory at the specified path with the specified name.
     *
     * @param pathName      The path at which the directory should be created at
     * @param directoryName The name for the directory
     */
    public void createDirectory(String pathName, String directoryName) {
        new File(pathName + "/" + directoryName).mkdir();
        System.out.println("Directory created at: " + pathName + "/" + directoryName);
    }

    /**
     * Creates an empty file at the specified directory.
     *
     * @param filename  The name of the file to create
     * @param directory The path for the datafile to be created
     * @throws IOException
     */
    public void createDatafile(String filename, String directory) throws IOException {
        File datafile = new File("./dbs/" + directory + "/" + filename);

        FileWriter fw = new FileWriter(datafile);
        fw.write("@CC-dbs\n");
        fw.close();

        System.out.println("Datafile created at: ./dbs/" + directory + "/" + filename);
    }

    public void writeLine(String filepath, String text) throws IOException {
        File file = new File(filepath);
        List<String> lines = dr.getFileContents(file);

        lines.add(text);

        Files.write(file.toPath(), lines);
    }
}