package com.thom.cs.data;

import com.thom.cs.packet.handler.PacketHandler;

import java.net.Socket;

public class DataHandler {
    public static void handle(String data, Socket client) {
        if (data.startsWith("#Packet")) {
            System.out.println("Received packet from client: " + client.toString());
            System.out.println(data);

            PacketHandler.handle(data, client);
        }
    }
}