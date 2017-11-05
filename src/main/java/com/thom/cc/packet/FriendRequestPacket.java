package com.thom.cc.packet;

import com.thom.cc.account.Account;
import lombok.Data;

import java.util.Date;

@Data
public class FriendRequestPacket extends Packet {
    private final  Account sender;
    private final Account receiver;
    private final Date timeStamp;

    public FriendRequestPacket(Account sender, Account receiver, Date dateTime) {
        super(PacketReference.FRIENDREQUEST_PACKET);
        this.sender = sender;
        this.receiver = receiver;
        this.timeStamp = dateTime;
    }
}