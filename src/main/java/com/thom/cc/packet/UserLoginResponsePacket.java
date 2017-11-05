package com.thom.cc.packet;

import lombok.Data;

@Data
public class UserLoginResponsePacket extends Packet {
    private final boolean loginAccpeted;

    public UserLoginResponsePacket(boolean value) {
        super(PacketReference.USERLOGINRESPONSE_PACKET);
        loginAccpeted = value;
    }
}