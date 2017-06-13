package com.thom.cs.account;

import java.util.ArrayList;

public class Account 
{
	private String username;
	private String password;
	
	public ArrayList<Account> friendList = new ArrayList<Account>();
	
	public Account(String user, String pass) 
	{
		this.username = user;
		this.password = pass;
	}

	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}
	
	public ArrayList<Account> getFriendList() 
	{
		return friendList;
	}
	
	public void addFriend(Account acc)
	{
		friendList.add(acc);
	}
}