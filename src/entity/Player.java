package entity;

import main.KeyHandler;
import main.Panel;

import java.awt.*;

public class Player extends Entity {
    Panel p;
    KeyHandler k;

    public Player(Panel p, KeyHandler k) {
        this.p = p;
        this.k = k;
        defaultV();
    }
    public void defaultV() {
        x = 96;
        y = 96;
        speed = 8;
    }
    public void update(){
        if (k.up){
            y -= speed;
        }
        if (k.down){
            y += speed;
        }
        if (k.left){
            x -= speed;
        }
        if (k.right){
            x += speed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, p.finalTileSize, p.finalTileSize);
    }
}
