package com.thom.cc.packet;

import com.thom.cc.account.Account;
import lombok.Data;

@Data
public class RegisterPacket extends Packet {
    private final Account user;

    public RegisterPacket(Account user) {
        super(PacketReference.REGISTER_PACKET);
        this.user = user;
    }
}	