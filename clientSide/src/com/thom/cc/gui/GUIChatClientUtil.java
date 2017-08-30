package com.thom.cc.gui;

public class GUIChatClientUtil 
{
	public static void hideLoginScreen()
	{
		GUIChatClient.username.setVisible(false);
		GUIChatClient.password.setVisible(false);
		GUIChatClient.login.setEnabled(false);
		GUIChatClient.login.setVisible(false);
		GUIChatClient.register.setEnabled(false);
		GUIChatClient.register.setVisible(false);
		
		GUIChatClient.loginPanel.setVisible(false);
		GUIChatClient.loginLbl0.setVisible(false);
		GUIChatClient.loginLbl1.setVisible(false);
		GUIChatClient.loginLbl2.setVisible(false);
		GUIChatClient.loginLbl3.setVisible(false);
	}
}