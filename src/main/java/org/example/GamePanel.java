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
    private Enemy enemy;
    private ArrayList<Bullet> bullets;
    private int windowWidth = 800;
    private int windowHeight = 600;


    private int enemiesKilled = 0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        new Timer(20, this).start();

        player = new Player(50, 400, 50, 50);
        enemy = new Enemy("1", 100, 100, 50, 50);
        bullets = new ArrayList<>();
        gameKeyAdapter = new GameKeyAdapter(this);
        addKeyListener(gameKeyAdapter);

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enemy.update();
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
            if (bullet.getX() > enemy.getX() &&
                bullet.getX() + bullet.getWidth() < enemy.getX() + enemy.getWidth() &&
                bullet.getY() + bullet.getHeight() > enemy.getY() &&
                bullet.getY() < enemy.getY() + enemy.getHeight()) {
                enemy.setVisable(false);
                enemiesKilled += 1;
            }
        }

        // Collision detection with player
        if (enemy.getX2() > player.getX() && enemy.getX() < player.getX2() &&
            enemy.getY2() > player.getY() && enemy.getY() < player.getY2()) {
            player.setVisable(false);
            enemy.setVisable(false);
            enemiesKilled = 0;
            player.setHp(player.getHp()-1);
        }

        if (enemy.getY2() >= this.getHeight()) {
            enemy.setVisable(false);
            enemiesKilled = 0;
            player.setHp(player.getHp()-1);
        }

        repaint();
    }

    public void newGame() {
        player.setVisable(false);
        enemy.setVisable(false);
        enemiesKilled = 0;
        player.setHp(100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        enemy.draw(g);

        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica", Font.PLAIN, 24));
        g.drawString(String.valueOf(enemiesKilled), 20,40);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Helvetica", Font.PLAIN, 24));
        g.drawString("HP " + player.getHp(), this.getWidth() - 100, 40);

    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
