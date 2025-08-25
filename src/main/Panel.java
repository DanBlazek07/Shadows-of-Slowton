package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    int tileSize = 16;
    int scale = 3;
    public int finalTileSize = tileSize * scale;
    int screenRows = 16;
    int screenCols = 24;
    int width = screenCols * finalTileSize;
    int height = screenRows * finalTileSize;
    KeyHandler keyHandler = new KeyHandler();
    Thread game;
    Player player = new Player(this, keyHandler);
    int playerX = 96;
    int playerY = 96;
    int speed = 8;
    int FPS = 60;
    public Panel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    /**
     * starts the game
     **/
    public void start(){
        game = new Thread(this);
        game.start();
    }

    @Override
    public void run() {
        double interval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int counter = 0;
        while(game != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
                counter++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + counter);
                timer = 0;
                counter = 0;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}