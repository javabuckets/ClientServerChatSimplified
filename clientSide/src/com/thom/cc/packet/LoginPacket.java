package com.thom.cc.packet;

import java.util.Date;

import com.thom.cc.utility.PacketReference;

public class LoginPacket extends Packet
{
	private String username, password;
	private Date dateTime;
	
	public LoginPacket(String username, String password, Date dateTime) 
	{
		super(PacketReference.LOGIN_PACKET);
		this.username = username;
		this.password = password;
		this.dateTime = dateTime;
	}
}