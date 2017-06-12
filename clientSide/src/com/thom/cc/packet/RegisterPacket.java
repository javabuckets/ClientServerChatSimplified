package com.thom.cc.packet;

import javax.swing.JTextField;

import com.thom.cc.utility.PacketReference;

public class RegisterPacket extends Packet
{
	private JTextField username, password;
	
	public RegisterPacket(JTextField username, JTextField password) 
	{
		super(PacketReference.REGISTER_PACKET);
		this.username = username;
		this.password = password;
	}
	
	public JTextField getUsername() 
	{
		return username;
	}
	
	public JTextField getPassword() 
	{
		return password;
	}
}	