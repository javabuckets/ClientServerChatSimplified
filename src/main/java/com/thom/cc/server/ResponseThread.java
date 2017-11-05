package com.thom.cc.server;

import com.thom.cc.data.DataHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ResponseThread extends Thread {
    BufferedReader reader;
    Socket serverSocket;

    public ResponseThread(Socket socket) {
        try {
            serverSocket = socket;

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            handleServerCommand(reader.readLine(), serverSocket);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void handleServerCommand(String str, Socket serverSocket) {
        DataHandler.handle(str, serverSocket);
    }
}