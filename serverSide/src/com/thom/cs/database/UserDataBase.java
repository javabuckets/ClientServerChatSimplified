package com.thom.cs.database;

import java.util.ArrayList;

public class UserDataBase extends DataBase
{
	public ArrayList<String> usernames = new ArrayList<String>();
	public ArrayList<String> passwords = new ArrayList<String>();
	
	public UserDataBase() 
	{
		
	}
	
	public void store(String user, String pass)
	{
		usernames.add(user);
		passwords.add(pass);
		System.out.println("Stored: " + user + " & " + pass);
	}
}