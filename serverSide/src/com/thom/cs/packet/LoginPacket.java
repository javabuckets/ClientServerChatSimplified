package com.thom.cs.packet;

public class LoginPacket extends Packet
{
	private String username, password;
	
	public LoginPacket(String username, String password) 
	{
		super(PacketReference.LOGIN_PACKET);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public String getPassword() 
	{
		return password;
	}
}