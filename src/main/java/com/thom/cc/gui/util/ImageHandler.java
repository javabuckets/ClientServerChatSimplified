package com.thom.cc.gui.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    public static BufferedImage getImage(String path) {
        File file = new File(path);
        BufferedImage img = null;

        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

    public static ImageIcon getIcon(String localPath) {
        return new ImageIcon(localPath);
    }

}
