package org.example;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

// The GamePanel class - where the game and drawing happens
class GamePanel extends JPanel implements ActionListener {
    private Player player;
    private ArrayList<Bullet> bullets;

    public GamePanel() {
        player = new Player(50, 400, 50, 50);
        bullets = new ArrayList<>();

        Timer timer = new Timer(20, this);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.handleKeyPress(e);

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Bullet newBullet = new Bullet(player.getX() + 20, 400, 5, 10);
                    bullets.add(newBullet);
                }
            }
        });

        setFocusable(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Bullet bullet : bullets) {
            bullet.move();
        }

        bullets.removeIf(bullet -> !bullet.isOnScreen(getHeight()));

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);

        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }
}
