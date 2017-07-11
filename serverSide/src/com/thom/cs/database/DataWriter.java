package com.thom.cs.database;

import java.io.File;

public class DataWriter 
{
	public DataReader dr = new DataReader();
	
	/**
	 * Creates a directory with the given name inside the "dbs" directory.
	 * @param directoryName The name for the directory
	 */
	public void createDatabaseDirectory(String directoryName)
	{
		new File("./dbs/" + directoryName).mkdir();
	}
	
	/**
	 * Creates a directory at the specified path with the specified name.
	 * @param pathName The path at which the directory should be created at
	 * @param directoryName The name for the directory
	 */
	public void createDirectory(String pathName, String directoryName)
	{
		new File(pathName + "/" + directoryName).mkdir();
	}
	
	/**
	 * Creates an empty file at the specified directory.
	 * @param filename The name of the file to create
	 * @param directory The path for the datafile to be created
	 */
	public void createDatafile(String filename, String directory)
	{
		new File("./dbs/" + directory + "/" + filename);
	}
}