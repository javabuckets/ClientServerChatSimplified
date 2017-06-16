package com.thom.cc.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class GUIScreen extends JFrame
{
	// local screen width & height
	protected static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	protected static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public GUIScreen(String title)
	{
		super(title);
	}
	
	public abstract void drawScreen();
}