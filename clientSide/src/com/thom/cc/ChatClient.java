package com.thom.cc;

import java.net.Socket;

import com.thom.cc.gui.GUIChatClient;

public class ChatClient 
{
	public static boolean isConnectedToServer = false;
	public static Socket SERVER_SOCKET;
	
	public static void main(String[] args) 
	{
		new GUIChatClient();
	}
}