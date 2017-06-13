package com.thom.cs.packet;

import java.net.Socket;
import java.util.ArrayList;

import com.thom.cs.packet.handler.LoginPacketHandler;
import com.thom.cs.packet.handler.RegisterPacketHandler;

public class PacketHandler 
{
	public static void handle(String packetData, Socket client)
	{
		int packetId = Integer.valueOf(packetData.substring(10, packetData.indexOf(';')));

		switch (packetId) 
		{
		case PacketReference.LOGIN_PACKET:
			LoginPacket loginPacket = new LoginPacket(packetId, retrieveDataset(1, packetData), retrieveDataset(2, packetData));
			LoginPacketHandler.handle(loginPacket, client);
			break;
		case PacketReference.REGISTER_PACKET:
			RegisterPacket registerPacket = new RegisterPacket(packetId, retrieveDataset(1, packetData), retrieveDataset(2, packetData));
			RegisterPacketHandler.handle(registerPacket, client);
			break;
		default:
			System.err.println("Invalid Packet Id");
			break;
		}
	}
	
	public static String retrieveDataset(int index, String packetData)
	{
		ArrayList<Integer> semicolonPositions = new ArrayList<Integer>();
		
		semicolonPositions.add(0);
		for (int i = 0; i < packetData.length(); i++)
		{
			if (packetData.charAt(i) == ';')
			{
				semicolonPositions.add(i+1);
			}
		}
		semicolonPositions.add(packetData.length());
		
		return packetData.substring(semicolonPositions.get(index), semicolonPositions.get(index+1)-1);
	}
}