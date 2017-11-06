package com.thom.cc.gui;

import com.thom.cc.gui.util.ImageHandler;

import javax.swing.*;
import java.awt.*;

public abstract class GUIScreen extends JFrame {
    // local screen width & height
    protected static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    protected static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public GUIScreen(String title) {
        super(title);
        setIconImage(ImageHandler.getImage("./src/main/resources/logo.png"));
    }

    public abstract void drawScreen();
}