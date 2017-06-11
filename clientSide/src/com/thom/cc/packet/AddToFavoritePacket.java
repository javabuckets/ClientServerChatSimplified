package com.thom.cc.packet;

import java.util.Date;

import com.thom.cc.account.Account;
import com.thom.cc.utility.PacketReference;

public class AddToFavoritePacket extends Packet
{
	private Account sender;
	private Account receiver;
	private Date dateTime;
	
	public AddToFavoritePacket(Account sender, Account receiver, Date dateTime) 
	{
		super(PacketReference.ADDTOFAVORITE_PACKET);
		this.sender = sender;
		this.receiver = receiver;
		this.dateTime = dateTime;
	}
}