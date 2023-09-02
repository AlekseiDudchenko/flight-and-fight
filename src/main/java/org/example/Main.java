package org.example;


import javax.swing.*;

/**
 * Entry point
 */
public class Main  {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 2D Game");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
