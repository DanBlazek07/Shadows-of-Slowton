package main;

import entity.Player;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    int tileSize = 16;
    int scale = 3;
    public int finalTileSize = tileSize * scale;
    public int screenRows = 16;
    public int screenCols = 24;
    public int width = screenCols * finalTileSize;
    public int height = screenRows * finalTileSize;
    KeyHandler keyHandler = new KeyHandler();
    Thread game;
    public Player player = new Player(this, keyHandler);
    int FPS = 60;
    TileManager tileManager = new TileManager(this);
    public int maxWorldCol = 36;
    public int maxWorldRow = 23;
    public int worldWidth = finalTileSize*maxWorldCol;
    public int worldHeight = finalTileSize*maxWorldRow;
    public Panel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
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
        tileManager.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}