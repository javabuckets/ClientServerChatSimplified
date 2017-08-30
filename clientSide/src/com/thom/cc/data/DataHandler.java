package com.thom.cc.data;

import java.net.Socket;

import com.thom.cc.packet.handler.PacketHandler;

public class DataHandler 
{
	public static void handle(String data, Socket serverSocket)
	{
		if (data.startsWith("#Packet"))
		{
			System.out.println("Received packet from server: " + serverSocket.toString());
			System.out.println(data);
			
			PacketHandler.handle(data, serverSocket);
		}
	}
}