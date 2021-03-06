package com.thom.cs.packet.handler;

import com.thom.cs.database.DataBaseHandler;
import com.thom.cs.packet.RegisterPacket;
import com.thom.cs.util.ClientUtil;

import java.net.Socket;

public class RegisterPacketHandler {
    public static void handle(RegisterPacket packet, Socket client) {
        if (!DataBaseHandler.userDatabase.store(packet.getUsername(), packet.getPassword(), true)) {
            ClientUtil.tellClient(client, "That username is already taken!");
        }
    }
}