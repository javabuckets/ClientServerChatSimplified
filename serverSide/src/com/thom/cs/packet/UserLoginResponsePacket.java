package com.thom.cs.packet;

public class UserLoginResponsePacket extends Packet
{
	private boolean loginAccpeted;
	
	public UserLoginResponsePacket(boolean value) 
	{
		super(PacketReference.USERLOGINRESPONSE_PACKET);
		this.loginAccpeted = value;
	}
	
	public boolean isLoginAccpeted() 
	{
		return loginAccpeted;
	}
}