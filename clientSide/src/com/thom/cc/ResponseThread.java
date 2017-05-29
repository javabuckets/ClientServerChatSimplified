package com.thom.cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ResponseThread extends Thread
{
	BufferedReader reader;

	public ResponseThread(Socket socket) 
	{
		try 
		{
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(isr);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void run() 
	{
		try 
		{
			System.out.println(reader.readLine());
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}
}
