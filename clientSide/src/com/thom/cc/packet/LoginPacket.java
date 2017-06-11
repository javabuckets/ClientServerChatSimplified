package com.thom.cc.packet;

import com.thom.cc.utility.PacketReference;

public class LoginPacket extends Packet
{
	private String username, password;
	
	public LoginPacket(String username, String password) 
	{
		super(PacketReference.LOGIN_PACKET);
		this.username = username;
		this.password = password;
	}
}