package main;

import entity.Entity;
import entity.Player;
import items.Item;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    private final int tileSize = 16;
    int scale = 3;
    public int finalTileSize = tileSize * scale;
    public int screenRows = 16;
    public int screenCols = 24;
    public int width = screenCols * finalTileSize;
    public int height = screenRows * finalTileSize;
    KeyHandler keyHandler = new KeyHandler();
    Thread game;
    public CollisionManager cManager = new CollisionManager(this);
    public Player player = new Player(this, keyHandler);
    int FPS = 60;
    public final int maxWorldCol = 350;
    public final int maxWorldRow = 23;
    public final int worldWidth = finalTileSize*maxWorldCol;
    public final int worldHeight = finalTileSize*maxWorldRow;
    TileManager tileManager = new TileManager(this);
    Mapper mapper = new Mapper(this);
    public Item[] item = new Item[500];
    public UI ui = new UI(this);
    public Entity[] npc = new Entity[10];
    public Entity[] enemy = new Entity[50];

    public Panel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    /**
     * puts the item on the right place
     **/
    public void setItemsOnScreen() {
        mapper.setItem();
    }
    /**
     * puts the NPC on the screen to where it belongs
     **/
    public void setNPCOnScreen(){
        mapper.setNPC();
    }
    /**
     * puts enemy on the screen there, where it's meant to be
     **/
    public void setEnemyOnScreen(){
        mapper.setEnemy();
    }
    /**
     * starts the game
     **/
    public void start(){
        game = new Thread(this);
        game.start();
    }
    /**
     * makes the game to run
     **/
    @Override
    public void run() {
        double interval = (double) 1000000000 / FPS;
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
    /**
     * updates the entity accordingly
     **/
    public void update(){
        player.update();
        for(int i = 0; i < npc.length; i++){
            if(npc[i] != null){
                npc[i].update();
            }
        }
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] != null) {
                enemy[i].update();
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        for(int i = 0; i < item.length; i++){
            if(item[i] != null){
                item[i].draw(g2,this);
            }
        }
        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2, this);
            }
        }
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] != null) {
                enemy[i].draw(g2, this);
            }
        }
        player.draw(g2);
        ui.draw(g2);
        g2.dispose();
    }
}