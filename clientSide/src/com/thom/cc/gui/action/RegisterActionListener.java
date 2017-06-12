package com.thom.cc.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import com.thom.cc.ChatClient;
import com.thom.cc.packet.RegisterPacket;

public class RegisterActionListener implements ActionListener
{
	private PrintWriter pw;
	private RegisterPacket registerPacket;
	
	public RegisterActionListener(RegisterPacket registerPacket)
	{
		this.registerPacket = registerPacket;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			pw = new PrintWriter(ChatClient.connectedSocket.getOutputStream());
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
}