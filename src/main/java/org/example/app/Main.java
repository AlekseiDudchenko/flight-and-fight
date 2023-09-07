package org.example.app;


import org.example.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Entry point
 */
public class Main  {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 2D Game");

        GamePanel gamePanel = new GamePanel();
//        frame.add(gamePanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

        // Create Menu Items
        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add Action Listeners
        newGameItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for starting a new game
                gamePanel.newGame();
//                frame.add(gamePanel);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create JMenu and add Menu Items
        JMenu gameMenu = new JMenu("Game");
        gameMenu.add(newGameItem);
        gameMenu.add(exitItem);

        // Create JMenuBar and add JMenu
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(gameMenu);

        // Add JMenuBar to JFrame
        frame.setJMenuBar(menuBar);

        // Existing code to set up the frame
        frame.add(gamePanel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
