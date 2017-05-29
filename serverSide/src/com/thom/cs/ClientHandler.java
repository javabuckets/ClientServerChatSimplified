package com.thom.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable 
{
	ChatServer chatServer;
	BufferedReader reader;
	Socket socket;
	
	public ClientHandler(ChatServer chatServer, Socket clientSocket)
	{
		try 
		{
			this.chatServer = chatServer;
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
				//chatServer.tellEveryone(msg);
				tellClient(msg);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Lost connection with client: " + socket.toString());
		}
	}

	private void tellClient(String msg) 
	{
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}