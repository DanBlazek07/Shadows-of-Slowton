package entity;

import main.Panel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    Panel panel = new Panel();
    public int worldX, worldY;
    public int speed;
    public BufferedImage u1,u2,d1,d2,l1,l2,r1,r2,NPC,enemy;
    public String direction;
    public int spriteCount = 0;
    public int spriteNum = 1;
    public Rectangle bounds;
    public int boundsX, boundsY;
    public boolean collisionOn = false;
    public Entity(Panel panel){
        this.panel = panel;
    }
    public void draw(Graphics2D g2,Panel panel){
        int screenX = worldX - panel.player.worldX + panel.player.screenX;
        int screenY = worldY - panel.player.worldY + panel.player.screenY;
        if (worldX + panel.finalTileSize > panel.player.worldX - panel.player.screenX &&
                worldX - panel.finalTileSize < panel.player.worldX + panel.player.screenX &&
                worldY + panel.finalTileSize > panel.player.worldY - panel.player.screenY &&
                worldY - panel.finalTileSize < panel.player.worldY + panel.player.screenY) {
            g2.drawImage(, screenX, screenY, panel.finalTileSize, panel.finalTileSize, null);
        }
    }
}