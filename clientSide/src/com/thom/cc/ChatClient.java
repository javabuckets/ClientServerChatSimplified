package com.thom.cc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatClient extends JFrame
{		
	private static final String IP = "127.0.0.1";
	private static final int PORT = 5000;
	
	private JTextField output;
	private PrintWriter pw;
	private Socket socket;
	
	public ChatClient() 
	{
		super("Chat Client");
		drawScreen();
		establishConnectionToChatServer(IP, PORT);
		Thread thread = new ResponseThread(socket);
		thread.start();
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
	
	public class SendOutputListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				pw.println(output.getText());
				pw.flush();
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
		new ChatClient();
	}
}