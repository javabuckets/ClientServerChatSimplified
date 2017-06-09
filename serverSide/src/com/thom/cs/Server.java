package com.thom.cs;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server 
{
	private static final int PORT = 5000;

	private ArrayList<Socket> clientsConnected;

	public void initializeServer(int port)
	{
		clientsConnected = new ArrayList<Socket>();

		try 
		{
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Establishing Server at port: " + port);

			while (true)
			{
				Socket clientSocket = serverSocket.accept();
				clientsConnected.add(clientSocket);

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
		new Server().initializeServer(PORT);
	}
}