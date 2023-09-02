package org.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Enemy {

    private int x, y, width, height;
    private int speed = 1;

    private Color color;

    public void setHeight(int height) {
        this.height = height;
    }

    private String name;

    public boolean isVisalbe() {
        return visalbe;
    }

    public void setVisalbe(boolean visalbe) {
        this.visalbe = visalbe;
        if (visalbe) {
            color = getRandomColor();
        }
    }

    private boolean visalbe = true;

    public Enemy(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        if (visalbe) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }

    public void update() {
        if (!visalbe) {
            y = 0;
            x = (int) (Math.random() * 750);
            setVisalbe(true);
            speed += 1;
        }

        y += speed;
        if (y > 600) {
            y = 0;
            x = (int) (Math.random() * 750);
            setVisalbe(true);
        }
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public static Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }
}