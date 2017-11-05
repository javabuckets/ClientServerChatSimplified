package com.thom.cc;

import com.thom.cc.gui.GUIChatClient;

import java.net.Socket;

public class ChatClient {
    public static boolean isConnectedToServer = false;
    public static Socket SERVER_SOCKET;

    public static GUIChatClient chatClientLogin;

    public static void main(String[] args) {
        chatClientLogin = new GUIChatClient();
    }
}