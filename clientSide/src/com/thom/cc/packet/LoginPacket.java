package com.thom.cc.packet;

import javax.swing.JTextField;

public class LoginPacket extends Packet
{
	private JTextField username, password;
	
	public LoginPacket(JTextField username, JTextField password) 
	{
		super(PacketReference.LOGIN_PACKET);
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