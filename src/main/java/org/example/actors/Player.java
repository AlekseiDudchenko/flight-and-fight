package org.example.actors;

import org.example.GameKeyAdapter;

import java.awt.*;
import java.awt.event.KeyEvent;


// The Player class - representing the player's square
public class Player {
    private int x, y, width, height;

    private int hp = 100;

    private Color color;

    private boolean visable = true;

    private final int MOVING_STEP = 15;

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

        if (y < 0) {
            y = 0;
        } else if (y > 550) {
            y = 550;
        }
    }

    public void draw(Graphics g) {
        if (visable) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        } else {
            setVisable(true);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX2() {
        return x + width;
    }

    public int getY2() {
        return y + height;
    }

    public boolean isVisable() {
        return visable;
    }

    public void setVisable(boolean visable) {
        this.visable = visable;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
