package com.thom.cc.packet;

import java.util.Date;

import com.thom.cc.account.Account;
import com.thom.cc.utility.PacketReference;

public class FriendRequestPacket extends Packet
{
	private Account sender;
	private Account receiver;
	private Date dateTime;
	
	public FriendRequestPacket(Account sender, Account receiver, Date dateTime) 
	{
		super(PacketReference.FRIENDREQUEST_PACKET);
		this.sender = sender;
		this.receiver = receiver;
		this.dateTime = dateTime;
	}
}