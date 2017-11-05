package com.thom.cc.data;

import com.thom.cc.packet.handler.PacketHandler;

import java.net.Socket;

public class DataHandler {
    public static void handle(String data, Socket serverSocket) {
        if (data.startsWith("#Packet")) {
            System.out.println("Received packet from server: " + serverSocket.toString());
            System.out.println(data);

            PacketHandler.handle(data, serverSocket);
        }
    }
}