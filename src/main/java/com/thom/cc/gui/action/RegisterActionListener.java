package com.thom.cc.gui.action;

import com.thom.cc.ChatClient;
import com.thom.cc.account.Account;
import com.thom.cc.gui.GUIPopUp;
import com.thom.cc.packet.RegisterPacket;
import com.thom.cc.server.ResponseThread;
import com.thom.cc.utility.PasswordEncrypter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class RegisterActionListener implements ActionListener {
    private PrintWriter pw;
    private RegisterPacket registerPacket;
    private JTextField username, password;

    public RegisterActionListener(JTextField username, JTextField password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.registerPacket = new RegisterPacket(new Account(username.getText(), password.getText()));
            pw = new PrintWriter(ChatClient.SERVER_SOCKET.getOutputStream());
            sendRegisterPacket();
            GUIPopUp popUp = new GUIPopUp("Account Registered.", 1500);
            pw.flush();

            Thread thread = new ResponseThread(ChatClient.SERVER_SOCKET);
            thread.start();
        } catch (Exception ex) {
            GUIPopUp popUp = new GUIPopUp("Account Creation Failed.", 1500);
            ex.printStackTrace();
        }
    }

    private void sendRegisterPacket() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int packetID = registerPacket.getPacketType();
        PasswordEncrypter passwordEncrypter = new PasswordEncrypter();

        String id = "#PacketID:" + packetID + ";";
        String user = "USER:" + registerPacket.getUser().getUsername() + ";";
        String pass = "PASS:" + passwordEncrypter.getEncryptedPassword(registerPacket.getUser().getPassword()) + ";";

        String data = id + user + pass + "#END";

        System.out.println(data);
        pw.println(data);
    }
}