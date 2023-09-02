package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;


// The Player class - representing the player's square
class Player {
    private int x, y, width, height;

    private final int MOVING_STEP = 15;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void handleKeyPress(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            x -= MOVING_STEP;
        } else if (key == KeyEvent.VK_RIGHT) {
            x += MOVING_STEP;
        } else if (key == KeyEvent.VK_UP) {
            y -= MOVING_STEP;
        } else if (key == KeyEvent.VK_DOWN) {
            y += MOVING_STEP;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

}
