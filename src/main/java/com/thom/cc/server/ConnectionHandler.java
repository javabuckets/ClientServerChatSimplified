package com.thom.cc.server;

import com.thom.cc.ChatClient;

import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler {
    // Default Settings
    private static final String IP = "192.168.1.79";
    private static final int PORT = 5000;

    public static Socket establishConnectionToServer(String ip, int port) {
        Socket socket;

        try {
            socket = new Socket(ip, port);
            System.out.println("Connection established with " + ip + ":" + port);
            ChatClient.isConnectedToServer = true;
            ChatClient.SERVER_SOCKET = socket;

            return socket;
        } catch (IOException e) {
            System.err.println("Failed to connect to " + ip + ":" + port);
        }

        return null;
    }

    public static String getStdIp() {
        return IP;
    }

    public static int getStdPort() {
        return PORT;
    }
}