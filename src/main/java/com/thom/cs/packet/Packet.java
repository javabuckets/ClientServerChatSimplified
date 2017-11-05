package com.thom.cs.packet;

public abstract class Packet {
    private int packetType;

    public Packet(int packetType) {
        this.packetType = packetType;
    }

    public int getPacketType() {
        return packetType;
    }

    public void setPacketType(int packetType) {
        this.packetType = packetType;
    }
}