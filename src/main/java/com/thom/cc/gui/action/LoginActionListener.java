package com.thom.cc.gui.action;

import com.thom.cc.ChatClient;
import com.thom.cc.account.Account;
import com.thom.cc.gui.GUIPopUp;
import com.thom.cc.packet.LoginPacket;
import com.thom.cc.server.ResponseThread;
import com.thom.cc.utility.PasswordEncrypter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class LoginActionListener implements ActionListener {
    private PrintWriter pw;
    private LoginPacket loginPacket;
    private JTextField username, password;

    public LoginActionListener(JTextField username, JTextField password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.loginPacket = new LoginPacket(new Account(username.getText(), password.getText()));
            pw = new PrintWriter(ChatClient.SERVER_SOCKET.getOutputStream());
            sendLoginPacket();
            pw.flush();

            Thread thread = new ResponseThread(ChatClient.SERVER_SOCKET);
            thread.start();
        } catch (Exception ex) {
            GUIPopUp popUp = new GUIPopUp("Login Failed.", 1500);
            ex.printStackTrace();
        }
    }

    private void sendLoginPacket() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int packetID = loginPacket.getPacketType();
        PasswordEncrypter passwordEncrypter = new PasswordEncrypter();

        String id = "#PacketID:" + packetID + ";";
        String user = "USER:" + loginPacket.getUser().getUsername() + ";";
        String pass = "PASS:" + passwordEncrypter.getEncryptedPassword(loginPacket.getUser().getPassword()) + ";";

        String data = id + user + pass + "#END";

        pw.println(data);
    }
}