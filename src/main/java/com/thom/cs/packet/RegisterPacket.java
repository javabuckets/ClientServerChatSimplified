package com.thom.cs.packet;

public class RegisterPacket extends Packet {
    private String username, password;

    public RegisterPacket(String username, String password) {
        super(PacketReference.REGISTER_PACKET);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}