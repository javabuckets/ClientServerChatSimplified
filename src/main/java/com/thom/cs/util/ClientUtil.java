package com.thom.cs.util;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientUtil {
    public static void tellClient(Socket socket, String msg) {
        try {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(msg);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
