package com.thom.cs;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatServer 
{
	private static final int PORT = 5000;
	
	private ArrayList clientOutputStreams;
	
	public void initializeChatServer()
	{
		clientOutputStreams = new ArrayList();
		
		try 
		{
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Establishing Server at port " + PORT);
			
			while (true)
			{
				Socket clientSocket = serverSocket.accept();
				PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(pw);
				
				Thread thread = new Thread(new ClientHandler(this, clientSocket));
				thread.start();
				System.out.println("Got a connection from: " + clientSocket.toString());
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		new ChatServer().initializeChatServer();
	}
	
	public void tellEveryone(String message)
	{
		Iterator iterator = clientOutputStreams.iterator();

		while (iterator.hasNext())
		{
			try 
			{
				PrintWriter pw = (PrintWriter) iterator.next();
				pw.println(message);
				pw.flush();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}