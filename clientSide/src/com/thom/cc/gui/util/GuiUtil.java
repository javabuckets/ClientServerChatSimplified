package com.thom.cc.gui.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.thom.cc.utility.ColorReference;

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
	
	public static JTextField addTextField(JPanel panel, String text, Point pos, int width, int height, Font font)
	{
		JTextField textfield = new JTextField(text);
		textfield.setBounds(pos.x, pos.y, width, height);
		textfield.setVisible(true);
		textfield.setBackground(new Color(40, 42, 45));
		textfield.setBorder(new LineBorder(new Color(35, 37, 40), 2));
		textfield.setFont(font);
		textfield.setForeground(Color.white);
		panel.add(textfield, 3, 0);
		
		return textfield;
	}
	
	public static JPasswordField addPasswordField(JPanel panel, Point pos, int width, int height, Font font)
	{
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(pos.x, pos.y, width, height);
		passwordField.setVisible(true);
		passwordField.setBackground(new Color(40, 42, 45));
		passwordField.setBorder(new LineBorder(new Color(35, 37, 40), 2));
		passwordField.setFont(font);
		passwordField.setForeground(Color.white);
		panel.add(passwordField, 3, 0);
		
		return passwordField;
	}
	
	public static JButton addButton(JPanel panel, String text, Point pos, int width, int height, ActionListener action)
	{
		JButton button = new JButton(text);
		button.setBounds(pos.x, pos.y, width, height);
		button.addActionListener(action);
		button.setVisible(true);
		button.setBackground(ColorReference.orange);
		button.setForeground(Color.white);
		button.setBorder(new LineBorder(ColorReference.darkOrange, 2));
		button.setFocusPainted(false);
		panel.add(button, 3, 0);
		
		return button;
	}
	
	public static JLabel addLabel(JLabel label, JPanel panel, String text, Point pos, Font font)
	{
		JLabel lbl = new JLabel(text);
		lbl.setBounds(pos.x, pos.y, text.length()*12, font.getSize());
		lbl.setVisible(true);
		lbl.setForeground(Color.white);
		lbl.setFont(font);
		panel.add(lbl, 3, 0);
		
		return lbl;
	}
	
	public static JLabel addTitleLabel(JLabel label, JPanel panel, String text, Point pos, Font font)
	{
		JLabel lbl = addLabel(label, panel, text, pos, font);
		lbl.setBounds(pos.x, pos.y, text.length()*font.getSize(), font.getSize());
		
		return lbl;
	}
	
	public static JLabel addFilledPane(JLabel pane, JPanel panel, Rectangle bounds, Color color)
	{
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(color, Integer.MAX_VALUE));
		label.setBounds(bounds);
		label.setVisible(true);
		panel.add(label, 2, 0);
		
		return label;
	}
}