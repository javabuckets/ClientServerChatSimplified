package com.thom.cs.database;

import java.util.ArrayList;

public class DataBaseHandler 
{
	private static ArrayList<DataBase> databases = new ArrayList<DataBase>();
	
	public static UserDataBase userDatabase = null;
	
	/**
	 * Initializes all databases;
	 * 1. Loads them to the databases ArrayList.
	 * 2. Updates their data sets (if the database has data stored it will load that to the database).
	 * 3. Initializes databases that have never been so before.
	 */
	public static void initDatabases()
	{
		// Initialization
		userDatabase = new UserDataBase(); 
		
		
		
		
		// Initially loads all the databases into the ArrayList for loopability
		loadDatabases();
		
		// Updates all databases (if a database has locally stored data, it is loaded here)
		updateDatabases();
		
		// Clears all the databases and loads them in again with the new and update data
		databases.clear();
		loadDatabases();
	}
	
	/**
	 * Calls the updateData() method in each and every database in the databases ArrayList.
	 */
	private static void updateDatabases() 
	{
		for (DataBase db : databases)
		{
			db.updateData();
		}
	}

	/**
	 * Adds all the databases to the databases ArrayList.
	 */
	private static void loadDatabases() 
	{
		databases.add(userDatabase);
	}
}