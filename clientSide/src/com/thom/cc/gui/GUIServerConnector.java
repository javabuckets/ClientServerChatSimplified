package com.thom.cc.gui;

import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.cc.server.ConnectionHandler;
import com.thom.cc.utility.GuiUtil;

public class GUIServerConnector extends JFrame
{
	public GUIServerConnector() 
	{
		super("Server Connector");
		drawScreen();
	}

	private JPanel panel;
	
	// Joining Server
	private JTextField connect_IP, connect_PORT;
	private JButton connect, autoconnect;
	
	private void drawScreen() 
	{
		setSize(200, 120);
		setResizable(false);
		
		panel = new JPanel(null);
		
		connect_IP = GuiUtil.addTextField(panel, "IP", new Point(5, 5), 120, 20);
		connect_PORT = GuiUtil.addTextField(panel, "PORT", new Point(125, 5), 65, 20);
		
		connect = GuiUtil.addButton(panel, "Connect", new Point((200/2-50), 30), 100, 20, (ActionEvent) -> 
		{ 
			ConnectionHandler.establishConnectionToServer(connect_IP.getText(), Integer.valueOf(connect_PORT.getText())); 
			setVisible(false);
			dispose();
		});
		
		autoconnect = GuiUtil.addButton(panel, "Auto Connect", new Point((200/2-75), 55), 150, 20, (ActionEvent) ->
		{
			ConnectionHandler.establishConnectionToServer(ConnectionHandler.getStdIp(), ConnectionHandler.getStdPort());
			setVisible(false);
			dispose();
		});
		
		this.add(panel);
		this.setVisible(true);
	}
}