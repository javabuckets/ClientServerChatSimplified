package com.thom.cs.packet.handler;

import java.net.Socket;

import com.thom.cs.database.DataBaseHandler;
import com.thom.cs.packet.LoginPacket;
import com.thom.cs.packet.PacketReference;
import com.thom.cs.packet.UserLoginResponsePacket;
import com.thom.cs.util.ClientUtil;

public class LoginPacketHandler 
{
	private static boolean flag = false;
	
	public static void handle(LoginPacket packet, Socket client)
	{	
		if (DataBaseHandler.userDatabase.usernames.contains(packet.getUsername()))
		{
			// The index of the username in the usernames list
			int index = DataBaseHandler.userDatabase.usernames.indexOf(packet.getUsername());
		
			// If the password in the database is that of the password the user is trying to login with
			if (DataBaseHandler.userDatabase.passwords.get(index).equals(packet.getPassword()))
			{
				flag = true;
				//ClientUtil.tellClient(client, "The password matches!");
			}
			else
			{
				flag = false;
				//ClientUtil.tellClient(client, "The password does not match, check to see if you spelled the username correctly.");
			}
		}
		else
		{
			flag = false;
			//ClientUtil.tellClient(client, "That user does not exist in the database, check to see if you spelled the username correctly.");
		}
		
		sendLoginResponse(client);
	}
	
	private static void sendLoginResponse(Socket client)
	{
		int packetID = PacketReference.USERLOGINRESPONSE_PACKET;
		
		String id = "#PacketID:" + packetID + ";";
		String value = String.valueOf(flag) + ";";
		
		String data = id + value + "#END";
		ClientUtil.tellClient(client, data);
		
		System.out.println("Sending packet of ID: " + packetID + ", to client: " + client.toString());
	}
}