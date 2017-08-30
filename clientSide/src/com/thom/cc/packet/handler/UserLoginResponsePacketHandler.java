package com.thom.cc.packet.handler;

import java.net.Socket;

import com.thom.cc.ChatClient;
import com.thom.cc.gui.GUIChatClient;
import com.thom.cc.gui.GUIChatClientUtil;
import com.thom.cc.packet.UserLoginResponsePacket;

public class UserLoginResponsePacketHandler 
{
	public static void handle(UserLoginResponsePacket packet, Socket serverSocket)
	{
		if (packet.isLoginAccpeted())
		{
			// Change from LOGIN screen to HOME screen
			GUIChatClientUtil.hideLoginScreen();
			GUIChatClient.drawHomepage();
		}
		else
		{
			// Throw some kind of error
		}
	}
}