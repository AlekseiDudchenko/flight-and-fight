package org.example;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// The GamePanel class - where the game and drawing happens
class GamePanel extends JPanel implements ActionListener {
    private Player player;
    private GameKeyAdapter gameKeyAdapter;
    private Enemy emeny;
    private ArrayList<Bullet> bullets;

    private int enemiesKilled = 0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        new Timer(20, this).start();

        player = new Player(50, 400, 50, 50);
        emeny = new Enemy("1", 100, 100, 50, 50);
        bullets = new ArrayList<>();
        gameKeyAdapter = new GameKeyAdapter(this);
        addKeyListener(gameKeyAdapter);

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        emeny.update();
        player.update(gameKeyAdapter);

        if (gameKeyAdapter.getSpacePressed().get()) {
            Bullet newBullet = new Bullet(player.getX() + 20, player.getY(), 5, 10);
            bullets.add(newBullet);
        }

        for (Bullet bullet : bullets) {
            bullet.update();
        }

        bullets.removeIf(bullet -> !bullet.isOnScreen(getHeight()));

        // Collision detection bullet with enemy
        for (Bullet bullet : bullets) {
            if (bullet.getX() > emeny.getX() &&
                bullet.getX() + bullet.getWidth() < emeny.getX() + emeny.getWidth() &&
                bullet.getY() + bullet.getHeight() > emeny.getY() &&
                bullet.getY() < emeny.getY() + emeny.getHeight()) {
                emeny.setVisalbe(false);
                enemiesKilled += 1;
            }
        }

        // Collision detection with player
        if (emeny.getX2() > player.getX() && emeny.getX() < player.getX2() &&
            emeny.getY2() > player.getY() && emeny.getY() < player.getY2()) {
            player.setVisable(false);
            enemiesKilled = 0;


        }

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        emeny.draw(g);

        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }


        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica", Font.PLAIN, 24));
        g.drawString(String.valueOf(enemiesKilled), 20,40);

    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEmeny() {
        return emeny;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
