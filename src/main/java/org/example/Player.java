package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;


// The Player class - representing the player's square
class Player {
    private int x, y, width, height;

    public boolean isVisable() {
        return visable;
    }

    public void setVisable(boolean visable) {
        this.visable = visable;
    }

    private boolean visable = true;

    private final int MOVING_STEP = 30;

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(GameKeyAdapter gka) {
        if (gka.getLeftPressed().get()) {
            x -= MOVING_STEP;
        }
        if (gka.getRightPressed().get()) {
            x += MOVING_STEP;
        }
        if (gka.getUpPressed().get()) {
            y -= MOVING_STEP;
        }
        if (gka.getDownPressed().get()) {
            y += MOVING_STEP;
        }

        if (x < 0) {
            x = 0;
        } else if (x > 750) {
            x = 750;
        }
    }

//    public void handleKeyPress(KeyEvent e) {
//        int key = e.getKeyCode();
//        if (key == KeyEvent.VK_LEFT) {
//            x -= MOVING_STEP;
//        } else if (key == KeyEvent.VK_RIGHT) {
//            x += MOVING_STEP;
//        } else if (key == KeyEvent.VK_UP) {
//            y -= MOVING_STEP;
//        } else if (key == KeyEvent.VK_DOWN) {
//            y += MOVING_STEP;
//        }
//
//        if (x < 0) {
//            x = 0;
//        } else if (x > 750) {
//            x = 750;
//        }
//
//    }

    public void draw(Graphics g) {
        if (visable) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
