package com.thom.cc.utility;

import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiUtil 
{
	public static JMenuBar drawMenuBar(JMenu[] menus, int[] mnemonics)
	{
		JMenuBar menubar = new JMenuBar();
		
		for (int i = 0; i < menus.length; i++)
		{
			if (mnemonics[i] != -1)
			{
				menus[i].setMnemonic(mnemonics[i]);
			}
			menubar.add(menus[i]);
		}
		
		return menubar;
	}
	
	public static JMenuItem addMenuItem(JMenu menu, String name, int mnemonic, String toolTip, ActionListener action)
	{
		JMenuItem item = new JMenuItem(name);
		item.setMnemonic(mnemonic);
		item.setToolTipText(toolTip);
		item.addActionListener(action);
		menu.add(item);
		
		return item;
	}
	
	public static JTextField addTextField(JPanel panel, String text, Point pos, int width, int height)
	{
		JTextField textfield = new JTextField(text);
		textfield.setBounds(pos.x, pos.y, width, height);
		textfield.setVisible(true);
		panel.add(textfield);
		
		return textfield;
	}
	
	public static JButton addButton(JPanel panel, String text, Point pos, int width, int height, ActionListener action)
	{
		JButton button = new JButton(text);
		button.setBounds(pos.x, pos.y, width, height);
		button.addActionListener(action);
		button.setVisible(true);
		panel.add(button);
		
		return button;
	}
}