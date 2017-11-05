package com.thom.cc.packet;

import com.thom.cc.account.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class AddToFavoritePacket extends Packet {
    private final Account sender;
    private final Account receiver;
    private final Date timeStamp;

    public AddToFavoritePacket(Account sender, Account receiver, Date timeStamp) {
        super(PacketReference.ADDTOFAVORITE_PACKET);
        this.sender = sender;
        this.receiver = receiver;
        this.timeStamp = timeStamp;
    }
}