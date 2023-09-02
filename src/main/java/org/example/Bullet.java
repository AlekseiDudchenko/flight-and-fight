package org.example;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
    private int x, y, width, height;

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move() {
        y -= 5;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }

    public boolean isOnScreen(int screenHeight) {
        return y + height > 0;
    }
}
