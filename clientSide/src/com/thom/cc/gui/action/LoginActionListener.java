package com.thom.cc.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thom.cc.ChatClient;
import com.thom.cc.packet.LoginPacket;
import com.thom.cc.server.ResponseThread;
import com.thom.cc.utility.DateUtil;

public class LoginActionListener implements ActionListener
{
	private PrintWriter pw;
	private LoginPacket loginPacket;
	
	public LoginActionListener(LoginPacket loginPacket)
	{
		this.loginPacket = loginPacket;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			pw = new PrintWriter(ChatClient.connectedSocket.getOutputStream());
			sendLoginPacket();
			pw.flush();
			
			Thread thread = new ResponseThread(ChatClient.connectedSocket);
			thread.start();
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
	
	private void sendLoginPacket()
	{
		int packetID = loginPacket.getPacketType();
		
		String id = "#PacketID:" + packetID + ";";
		String user = "USER:" + loginPacket.getUsername().getText() + ";";
		String pass = "PASS:" + loginPacket.getPassword().getText() + ";";
		
		String data = id + user + pass + "#END";
		
		pw.println(data);
	}
}