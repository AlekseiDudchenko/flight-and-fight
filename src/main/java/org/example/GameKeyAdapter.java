package org.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// The GameKeyAdapter class - for handling keyboard input
class GameKeyAdapter extends KeyAdapter {

    private static final int MOVING_STEP = 15;

    private Player player;
    private Enemy emeny;
    private ArrayList<Bullet> bullets;

    // Variables to keep track of key states
    AtomicBoolean leftPressed = new AtomicBoolean(false);

    public AtomicBoolean getLeftPressed() {
        return leftPressed;
    }

    public AtomicBoolean getRightPressed() {
        return rightPressed;
    }

    public AtomicBoolean getUpPressed() {
        return upPressed;
    }

    public AtomicBoolean getDownPressed() {
        return downPressed;
    }

    public AtomicBoolean getSpacePressed() {
        return spacePressed;
    }

    AtomicBoolean rightPressed = new AtomicBoolean(false);
    AtomicBoolean upPressed = new AtomicBoolean(false);
    AtomicBoolean downPressed = new AtomicBoolean(false);
    AtomicBoolean spacePressed = new AtomicBoolean(false);



    public GameKeyAdapter(GamePanel gamePanel) {
        player = gamePanel.getPlayer();
        emeny = gamePanel.getEmeny();
        bullets = gamePanel.getBullets();
    }
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//        player.handleKeyPress(e);
//
//        if (key == KeyEvent.VK_SPACE) {
//            Bullet newBullet = new Bullet(player.getX() + 20, 400, 5, 10);
//            bullets.add(newBullet);
//        }
//    }

//    @Override
//    public void keyPressed(KeyEvent e) {
//        player.handleKeyPress(e);
//
//        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            Bullet newBullet = new Bullet(player.getX() + 20, player.getY(), 5, 10);
//            bullets.add(newBullet);
//        }
//    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed.set(true);
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed.set(true);
                break;
            case KeyEvent.VK_UP:
                upPressed.set(true);
                break;
            case KeyEvent.VK_DOWN:
                downPressed.set(true);
                break;
            case KeyEvent.VK_SPACE:
                spacePressed.set(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftPressed.set(false);
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed.set(false);
                break;
            case KeyEvent.VK_UP:
                upPressed.set(false);
                break;
            case KeyEvent.VK_DOWN:
                downPressed.set(false);
                break;
            case KeyEvent.VK_SPACE:
                spacePressed.set(false);
                break;
        }
    }


}
