package com.thom.cc.packet;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Packet {
    private int packetType;
}