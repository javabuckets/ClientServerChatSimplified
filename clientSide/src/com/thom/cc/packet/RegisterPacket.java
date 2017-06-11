package com.thom.cc.packet;

import java.util.Date;

import com.thom.cc.utility.PacketReference;

public class RegisterPacket extends Packet
{
	private String username, password;
	private Date dateTime;
	
	public RegisterPacket(String username, String password, Date dateTime) 
	{
		super(PacketReference.REGISTER_PACKET);
		this.username = username;
		this.password = password;
		this.dateTime = dateTime;
	}
}	