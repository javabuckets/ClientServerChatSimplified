package com.thom.cc.packet;

import java.util.Date;

import com.thom.cc.account.Account;
import com.thom.cc.utility.PacketReference;

public class MessagePacket extends Packet
{
	Account sender;
	Account receiver;
	String message;
	Date dateTime;
	
	public MessagePacket(Account sender, Account receiver, String message, Date dateTime) 
	{
		super(PacketReference.MESSAGE_PACKET);
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
		this.dateTime = dateTime;
	}
}