package com.thom.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable 
{
	private Server server;
	private Socket socket;
	
	private BufferedReader reader;
	
	public ClientHandler(Server server, Socket clientSocket) 
	{
		try 
		{
			this.server = server;
			this.socket = clientSocket;
			
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			this.reader = new BufferedReader(isr);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void run() 
	{
		String msg;
		
		try 
		{
			while ((msg = reader.readLine()) != null)
			{
				System.out.println(msg);
				tellClient(msg);
			}
		} 
		catch (Exception e) 
		{
			System.err.println("Lost connection with client: " + socket.toString());
		}
	}
	
	private void tellClient(String msg)
	{
		try 
		{
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}