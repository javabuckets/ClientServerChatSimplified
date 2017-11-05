package com.thom.cc.gui;

import com.thom.cc.gui.util.GuiUtil;
import com.thom.cc.utility.ColorReference;
import com.thom.cc.utility.FontReference;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GUIPopUp extends GUIScreen {
    private String message;
    private int duration;

    public GUIPopUp(String message, int duration) {
        super("Pop-Up");
        this.message = message;
        this.duration = duration;
        drawScreen();
    }

    @Override
    public void drawScreen() {
        setSize(300, 150);
        getRootPane().setBorder(new LineBorder(ColorReference.orange, 2));
        setLocation(WIDTH / 2 - 150, HEIGHT / 2 - 75);
        setResizable(false);
        setUndecorated(true);
        requestFocus();

        JPanel panel = new JPanel(null);
        this.add(panel);

        GuiUtil.addLabel(new JLabel(), panel, message, new Point(20, 150 / 2 - 6), FontReference.defaultFont);

        panel.setBackground(ColorReference.bgColor);
        setVisible(true);

        Timer endTimer = new Timer();
        endTimer.schedule(new TimerTask() {
            public void run() {
                // Closes the Pop-Up
                setVisible(false);
                dispose();
            }
        }, duration);
    }
}