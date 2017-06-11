package com.thom.cc.packet;

import com.thom.cc.utility.PacketReference;

public class RegisterPacket extends Packet
{
	public RegisterPacket() 
	{
		super(PacketReference.REGISTER_PACKET);
	}
}