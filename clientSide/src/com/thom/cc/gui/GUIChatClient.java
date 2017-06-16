package com.thom.cc.gui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.cc.gui.action.LoginActionListener;
import com.thom.cc.gui.action.RegisterActionListener;
import com.thom.cc.packet.LoginPacket;
import com.thom.cc.packet.RegisterPacket;
import com.thom.cc.server.ConnectionHandler;
import com.thom.cc.utility.ColorReference;
import com.thom.cc.utility.FontReference;
import com.thom.cc.utility.GuiUtil;

public class GUIChatClient extends GUIScreen
{
	// JPanel where all components will be added to
	private JPanel panel;
	
	public GUIChatClient() 
	{
		super("Chat Client");
		drawScreen();
		attemptAutoConnect();
	}
	
	/**
	 * Draws the screen; GUI components
	 * @param width the width of the screen
	 * @param height the height of the screen
	 */
	@Override
	public void drawScreen()
	{
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		// --- GUI Layout ---
		panel = new JPanel(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT);

		// Draws the login screen on boot
		drawMenuBar();
		drawLoginScreen();
		
		add(panel);
		setVisible(true);
		
		panel.setBackground(ColorReference.bgColor);
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

	// GUI Components for Login Screen
	private JTextField username, password;
	private JButton login, register;
	
	private void drawLoginScreen()
	{
		GuiUtil.addFilledPane(new JLabel(), panel, new Rectangle(WIDTH/2 - 500, HEIGHT/2 - HEIGHT/4, 1000, HEIGHT/2), ColorReference.userpageColor);
		
		GuiUtil.addTitleLabel(new JLabel(), panel, "Chat Client", new Point(WIDTH/2 - 180, HEIGHT/2 - HEIGHT/4 + 20), FontReference.titleFont);
	
		GuiUtil.addLabel(new JLabel(), panel, "username", new Point(WIDTH/2 - 380, HEIGHT/2 - 80), FontReference.defaultFont);
		GuiUtil.addLabel(new JLabel(), panel, "password", new Point(WIDTH/2 - 380, HEIGHT/2 + 20), FontReference.defaultFont);
		GuiUtil.addLabel(new JLabel(), panel, "Don't have an account?", new Point(WIDTH/2 + 55, HEIGHT/2 + 15), FontReference.defaultFont);
		
		username = GuiUtil.addTextField(panel, "", new Point(WIDTH/2 - 380, HEIGHT/2 - 50), 300, 30, FontReference.defaultFont);
		password = GuiUtil.addPasswordField(panel, new Point(WIDTH/2 - 380, HEIGHT/2 + 50), 300, 30, FontReference.defaultFont);
		
		GuiUtil.addButton(panel, "Login", new Point(WIDTH/2 + 70, HEIGHT/2 - 55), 175, 40, new LoginActionListener(new LoginPacket(username, password)));
		GuiUtil.addButton(panel, "Register", new Point(WIDTH/2 + 70, HEIGHT/2 + 45), 175, 40, new RegisterActionListener(new RegisterPacket(username, password)));
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
	
	private void attemptAutoConnect()
	{
		System.out.println("Attempting to auto-connect to server...");
		ConnectionHandler.establishConnectionToServer(ConnectionHandler.getStdIp(), ConnectionHandler.getStdPort());
	}
}