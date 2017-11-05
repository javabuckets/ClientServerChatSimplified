package com.thom.cc.packet;

import com.thom.cc.account.Account;
import lombok.Data;

import java.util.Date;

@Data
public class MessagePacket extends Packet {
    private final Account sender;
    private final Account receiver;
    private final String message;
    private final Date timeStamp;

    public MessagePacket(Account sender, Account receiver, String message, Date dateTime) {
        super(PacketReference.MESSAGE_PACKET);
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timeStamp = dateTime;
    }
}