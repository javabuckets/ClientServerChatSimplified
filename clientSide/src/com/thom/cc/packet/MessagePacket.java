package com.thom.cc.packet;

import java.util.Date;

import com.thom.cc.account.Account;

public class MessagePacket extends Packet
{
	private Account sender;
	private Account receiver;
	private String message;
	private Date dateTime;
	
	public MessagePacket(Account sender, Account receiver, String message, Date dateTime) 
	{
		super(PacketReference.MESSAGE_PACKET);
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.dateTime = dateTime;
	}
}