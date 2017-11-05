package com.thom.cc.packet;

import com.thom.cc.account.Account;
import lombok.Data;

@Data
public class LoginPacket extends Packet {
    private final Account user;

    public LoginPacket(Account user) {
        super(PacketReference.LOGIN_PACKET);
        this.user = user;
    }
}