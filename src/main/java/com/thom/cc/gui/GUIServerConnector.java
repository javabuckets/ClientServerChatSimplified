package com.thom.cc.gui;

import com.thom.cc.gui.util.GuiUtil;
import com.thom.cc.server.ConnectionHandler;

import javax.swing.*;
import java.awt.*;

public class GUIServerConnector extends GUIScreen {
    public GUIServerConnector() {
        super("Server Connector");
        drawScreen();
    }

    private JPanel panel;

    // Joining Server
    private JTextField connect_IP, connect_PORT;
    private JButton connect, autoconnect;

    private Color bgColor = new Color(54, 57, 62);

    @Override
    public void drawScreen() {
        setSize(200, 120);
        setResizable(false);

        panel = new JPanel(null);

        connect_IP = GuiUtil.addTextField(panel, "IP", new Point(5, 5), 120, 20, Font.getFont("Arial"));
        connect_PORT = GuiUtil.addTextField(panel, "PORT", new Point(125, 5), 65, 20, Font.getFont("Arial"));

        connect = GuiUtil.addButton(panel, "Connect", new Point((200 / 2 - 50), 30), 100, 20, (ActionEvent) ->
        {
            ConnectionHandler.establishConnectionToServer(connect_IP.getText(), Integer.valueOf(connect_PORT.getText()));
            setVisible(false);
            dispose();
        });

        autoconnect = GuiUtil.addButton(panel, "Auto Connect", new Point((200 / 2 - 75), 55), 150, 20, (ActionEvent) ->
        {
            ConnectionHandler.establishConnectionToServer(ConnectionHandler.getStdIp(), ConnectionHandler.getStdPort());
            setVisible(false);
            dispose();
        });

        this.add(panel);
        this.setVisible(true);

        panel.setBackground(bgColor);
    }
}