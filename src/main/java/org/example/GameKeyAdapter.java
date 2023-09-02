package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

// The GameKeyAdapter class - for handling keyboard input
class GameKeyAdapter extends KeyAdapter {

    private static final int MOVING_STEP = 15;

    Player player;

    private ArrayList<Bullet> bullets;

    public GameKeyAdapter(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        player.handleKeyPress(e);

        if (key == KeyEvent.VK_SPACE) {
            Bullet newBullet = new Bullet(player.getX() + 20, 400, 5, 10);
            bullets.add(newBullet);
        }
    }
}
