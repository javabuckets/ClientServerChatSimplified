package com.thom.cc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thom.cc.gui.GUIChatClient;
import com.thom.cc.server.ResponseThread;

@SuppressWarnings("serial")
public class ChatClientOld extends JFrame
{		
	// Default Settings
	private static final String IP = "127.0.0.1";
	private static final int PORT = 5000;
	
	private JTextField output;
	private PrintWriter pw;
	private Socket socket;
	
	// Joining Server
	private JTextField connect_IP, connect_PORT;
	
	public ChatClientOld()
	{
		super("Chat Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawScreen();
	}
	
	private void drawScreen()
	{
		setSize(400, 200);
		JPanel panel = new JPanel();
		output = new JTextField(20);
		JButton sendOutputBtn = new JButton("Send");
		sendOutputBtn.addActionListener(new SendOutputListener());
		panel.add(output);
		panel.add(sendOutputBtn);
		
		// Joining Server
		connect_IP = new JTextField(15);
		connect_PORT = new JTextField(15);
		connect_IP.setText(IP);
		connect_PORT.setText(String.valueOf(PORT));
		panel.add(connect_IP);
		panel.add(connect_PORT);
		JButton connectBtn = new JButton("Connect");
		connectBtn.addActionListener(new EstablishConnection());
		panel.add(connectBtn);
		
		getContentPane().add(BorderLayout.CENTER, panel);
		setVisible(true);
	}

	private void establishConnectionToChatServer(String ip, int port)
	{
		try 
		{
			socket = new Socket(ip, port);
			pw = new PrintWriter(socket.getOutputStream());
			System.out.println("Connection established");
		} 
		catch (IOException e) 
		{
			System.err.println("Failed to connect to " + ip + ":" + port);
			e.printStackTrace();
		}
	}
	
	public class EstablishConnection implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			establishConnectionToChatServer(connect_IP.getText(), Integer.valueOf(connect_PORT.getText()));
		}
	}
	
	public class SendOutputListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				pw.println(output.getText());
				pw.flush();
				
				Thread thread = new ResponseThread(socket);
				thread.start();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			output.setText("");
			output.requestFocus();
		}
	}
	
	public static void main(String[] args) 
	{
//		new ChatClient();
		new GUIChatClient();
	}
}