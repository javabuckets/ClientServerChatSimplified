package com.thom.cc.packet.handler;

import com.thom.cc.packet.PacketReference;
import com.thom.cc.packet.UserLoginResponsePacket;

import java.net.Socket;
import java.util.ArrayList;

public class PacketHandler {
    public static void handle(String packetData, Socket serverSocket) {
        int packetId = Integer.valueOf(packetData.substring(10, packetData.indexOf(';')));

        switch (packetId) {
            case PacketReference.USERLOGINRESPONSE_PACKET:
                UserLoginResponsePacket userLoginResponsePacket = new UserLoginResponsePacket(Boolean.valueOf(retrieveDataset(1, packetData)));
                UserLoginResponsePacketHandler.handle(userLoginResponsePacket, serverSocket);
                break;
            default:
                System.err.println("Invalid Packet Id!");
                break;
        }
    }

    public static String retrieveDataset(int index, String packetData) {
        ArrayList<Integer> semicolonPositions = new ArrayList<Integer>();

        semicolonPositions.add(0);
        for (int i = 0; i < packetData.length(); i++) {
            if (packetData.charAt(i) == ';') {
                semicolonPositions.add(i + 1);
            }
        }
        semicolonPositions.add(packetData.length());

        return packetData.substring(semicolonPositions.get(index), semicolonPositions.get(index + 1) - 1);
    }
}