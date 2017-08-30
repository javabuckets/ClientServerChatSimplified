package com.thom.cc.packet;

public class UserLoginResponsePacket extends Packet
{
	private boolean loginAccpeted;
	
	public UserLoginResponsePacket(boolean value) 
	{
		super(PacketReference.USERLOGINRESPONSE_PACKET);
		loginAccpeted = value;
	}
	
	public boolean isLoginAccpeted() 
	{
		return loginAccpeted;
	}
}