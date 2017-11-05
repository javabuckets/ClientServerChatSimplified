package com.thom.cs.database;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class DataReader {
    public boolean doesDatafileExist(String filename, String dbsDir) throws IOException, FileNotFoundException {
        File datafile = new File("./dbs/" + dbsDir + "/" + filename);

        if (datafile.exists() && !datafile.isDirectory()) {
            BufferedReader br = new BufferedReader(new FileReader(datafile));
            String firstLine = br.readLine().trim();

            if (firstLine.equalsIgnoreCase("@CC-dbs")) {
                br.close();
                return true;
            }
            br.close();
        }
        return false;
    }

    public boolean doesDatabaseDirectoryExist(String dbsDirName) {
        File dbsDir = new File("./dbs/" + dbsDirName);

        if (dbsDir.exists() && dbsDir.isDirectory())
            return true;
        else
            return false;
    }

    public boolean doesDirectoryExist(File file) {
        if (file.exists() && file.isDirectory())
            return true;
        else
            return false;
    }

    public boolean doesFileExist(File file) {
        if (file.exists() && !file.isDirectory())
            return true;
        else
            return false;
    }

    public List<String> getFileContents(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    public String readLine(File file, int line) throws IOException {
        return getFileContents(file).get(line);
    }

    public boolean isDatafileEmpty(String filename, String dbsDir) throws FileNotFoundException, IOException {
        File datafile = new File("./dbs/" + dbsDir + "/" + filename);

        if (doesDatafileExist(filename, dbsDir)) {
            for (int i = 0; i < getFileContents(datafile).size(); i++) {
                if (getFileContents(datafile).get(i).contains(";")) {
                    System.out.println("Entry found at line " + (i + 1));
                    return false;
                }
            }
        }
        return true;
    }
}