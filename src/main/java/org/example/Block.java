package org.example;

import java.awt.*;

// The Block class - representing the falling block
class Block {
    int x, y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    public void update() {
        y += 5;
        if (y > 600) {
            y = 0;
            x = (int) (Math.random() * 750);
        }
    }
}
