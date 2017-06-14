package com.thom.cs.packet.handler;

import java.net.Socket;

import com.thom.cs.packet.LoginPacket;
import com.thom.cs.util.ClientUtil;

public class LoginPacketHandler 
{
	public static void handle(LoginPacket packet, Socket client)
	{	
		if (RegisterPacketHandler.userDatabase.usernames.contains(packet.getUsername()))
		{
			// The index of the username in the usernames list
			int index = RegisterPacketHandler.userDatabase.usernames.indexOf(packet.getUsername());
		
			// If the password in the database is that of the password the user is trying to login with
			if (RegisterPacketHandler.userDatabase.passwords.get(index).equals(packet.getPassword()))
			{
				ClientUtil.tellClient(client, "The password matches!");
			}
			else
			{
				ClientUtil.tellClient(client, "The password does not match, check to see if you spelled the username correctly.");
			}
		}
		else
		{
			ClientUtil.tellClient(client, "That user does not exist in the database, check to see if you spelled the username correctly.");
		}
	}
}