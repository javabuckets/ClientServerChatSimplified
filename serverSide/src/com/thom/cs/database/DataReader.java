package com.thom.cs.database;

import java.io.File;

public class DataReader 
{
	public boolean doesDirectoryExist(File file)
	{
		if (file.exists() && file.isDirectory())
			return true;
		else
			return false;
	}
	
	public boolean doesFileExist(File file)
	{
		if (file.exists() && !file.isDirectory())
			return true;
		else
			return false;
	}
}