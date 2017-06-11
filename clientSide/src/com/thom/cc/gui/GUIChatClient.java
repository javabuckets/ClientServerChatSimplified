package com.thom.cc.gui;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.thom.cc.gui.action.LoginActionListener;
import com.thom.cc.server.ConnectionHandler;
import com.thom.cc.utility.GuiUtil;

public class GUIChatClient extends JFrame
{
	// local screen width & height
	private static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	// JPanel where all components will be added to
	private JPanel panel;
	
	public GUIChatClient() 
	{
		super("Chat Client");
		drawScreen(WIDTH, HEIGHT);
	}
	
	/**
	 * Draws the screen; GUI components
	 * @param width the width of the screen
	 * @param height the height of the screen
	 */
	private void drawScreen(int width, int height)
	{
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// --- GUI Layout ---
		panel = new JPanel(null);
		panel.setBounds(0, 0, 20, height);

		// Draw Components
		drawMenuBar();
		drawTempUI(width, height);
//		drawUserpage();
//		drawContacts();
//		drawChatWindow();
		
		add(panel);
		setVisible(true);
	}

	JTextField username, password;
	JButton login, register;
	
	private void drawTempUI(int width, int height) 
	{
		// Login Screen
		username = GuiUtil.addTextField(panel, "username", new Point(25, 25), 150, 20);
		password = GuiUtil.addTextField(panel, "password", new Point(25, 50), 150, 20);
		
		login = GuiUtil.addButton(panel, "Login", new Point(180, 25), 100, 20, new LoginActionListener(username.getText(), password.getText()));
		register = GuiUtil.addButton(panel, "Register", new Point(180, 50), 100, 20, null);
	}

	private void drawMenuBar() 
	{
		// Menus & Mnemonics
		JMenu[] menus = { new JMenu("Th-CC"), new JMenu("Contacts"), new JMenu("Settings"), new JMenu("Help"), new JMenu("Exit") };
		int[] mnemonics = { KeyEvent.VK_T, KeyEvent.VK_C, KeyEvent.VK_S, KeyEvent.VK_H, -1 };
		
		// Menubar
		JMenuBar menubar = GuiUtil.drawMenuBar(menus, mnemonics);
		
		// Th-CC
		GuiUtil.addMenuItem(menus[0], "Connect", KeyEvent.VK_C, "Opens the connect interface", (ActionEvent) -> { new GUIServerConnector(); } );
		
		// Contacts
		 
		// Settings
		
		// Help
		
		// Exit
		GuiUtil.addMenuItem(menus[4], "Exit", KeyEvent.VK_E, "Exit Application", (ActionEvent) -> { System.exit(0); });
		
		setJMenuBar(menubar);
	}

	private void drawUserpage() 
	{
		
	}
	
	private void drawContacts() 
	{
		
	}
	
	private void drawChatWindow() 
	{
		
	}
}