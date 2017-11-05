package com.thom.cs;

import com.thom.cs.data.DataHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Server server;
    private Socket socket;

    private BufferedReader reader;

    public ClientHandler(Server server, Socket clientSocket) {
        try {
            this.server = server;
            this.socket = clientSocket;

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            this.reader = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String msg;

        try {
            while ((msg = reader.readLine()) != null) {
                DataHandler.handle(msg, socket);
            }
        } catch (Exception e) {
            System.err.println("Lost connection with client: " + socket.toString());
        }
    }
}