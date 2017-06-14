package com.thom.cc.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.thom.cc.ChatClient;
import com.thom.cc.packet.RegisterPacket;
import com.thom.cc.server.ResponseThread;
import com.thom.cc.utility.PasswordEncrypter;

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
		catch (IOException | NoSuchAlgorithmException ex) 
		{
			ex.printStackTrace();
		}
	}
	
	private void sendRegisterPacket() throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		int packetID = registerPacket.getPacketType();
		PasswordEncrypter passwordEncrypter = new PasswordEncrypter();
		
		String id = "#PacketID:" + packetID + ";";
		String user = "USER:" + registerPacket.getUsername().getText() + ";";
		String pass = "PASS:" + passwordEncrypter.getEncryptedPassword(registerPacket.getPassword().getText()) + ";";
		
		String data = id + user + pass + "#END";
		
		pw.println(data);
	}
}