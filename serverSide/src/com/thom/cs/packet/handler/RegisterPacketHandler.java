package com.thom.cs.packet.handler;

import java.net.Socket;

import com.thom.cs.database.UserDataBase;
import com.thom.cs.packet.RegisterPacket;

public class RegisterPacketHandler 
{
	static UserDataBase userDatabase = null;
	
	public static void handle(RegisterPacket packet, Socket client)
	{			
		if (userDatabase == null)
		{
			userDatabase = new UserDataBase();
		}
		
		userDatabase.store(packet.getUsername(), packet.getPassword());
	}
}