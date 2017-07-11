package com.thom.cs.database;

import java.io.File;
import java.util.ArrayList;

public class UserDataBase extends DataBase
{
	public ArrayList<String> usernames = new ArrayList<String>();
	public ArrayList<String> passwords = new ArrayList<String>();
	
	public UserDataBase() 
	{
		
	}
	
	@Override
	/**
	 * Reads the data (if any) from the server machine and loads it to the database
	 */
	public void updateData() 
	{
		
	}
	
	public void store(String user, String pass)
	{
		usernames.add(user);
		passwords.add(pass);
		System.out.println("Stored: " + user + " & " + pass);
	}
	
	private void storeDataLocally()
	{
		DataWriter dw = new DataWriter();
		
		if (dw.dr.doesDirectoryExist(new File("./dbs/users")))
		{
			System.out.println("Directory Users Exist");
		}
	}
}