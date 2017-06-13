package com.thom.cc.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import com.thom.cc.ChatClient;
import com.thom.cc.packet.RegisterPacket;
import com.thom.cc.server.ResponseThread;

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
			sendRegisterPacket();
			pw.flush();
			
			Thread thread = new ResponseThread(ChatClient.connectedSocket);
			thread.start();
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
	
	private void sendRegisterPacket()
	{
		int packetID = registerPacket.getPacketType();
		
		String id = "#PacketID:" + packetID + ";";
		String user = "USER:" + registerPacket.getUsername().getText() + ";";
		String pass = "PASS:" + registerPacket.getPassword().getText() + ";";
		
		String data = id + user + pass + "#END";
		
		pw.println(data);
	}
}