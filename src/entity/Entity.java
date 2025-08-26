package entity;

import main.Panel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    Panel panel;
    public int worldX, worldY;
    public int speed;
    public BufferedImage u1,u2,d1,d2,l1,l2,r1,r2,NPC,enemy;
    public String direction;
    public int spriteCount = 0;
    public int spriteNum = 1;
    public Rectangle bounds = new Rectangle(0,0,48,48);
    public int boundsX, boundsY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    public Entity(Panel panel){
        this.panel = panel;
    }
    public void action(){}
    public void update(){
        action();
        collisionOn = false;
        panel.cManager.checkTile(this);
        panel.cManager.checkItem(this,false);
        panel.cManager.checkPlayerCollision(this);
        if (!collisionOn) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        spriteCount++;
        if (spriteCount > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCount = 0;
        }
    }
    public void draw(Graphics2D g2,Panel panel){
        BufferedImage img = null;
        int screenX = worldX - panel.player.worldX + panel.player.screenX;
        int screenY = worldY - panel.player.worldY + panel.player.screenY;
        if (worldX + panel.finalTileSize > panel.player.worldX - panel.player.screenX &&
                worldX - panel.finalTileSize < panel.player.worldX + panel.player.screenX &&
                worldY + panel.finalTileSize > panel.player.worldY - panel.player.screenY &&
                worldY - panel.finalTileSize < panel.player.worldY + panel.player.screenY) {
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        img = u1;
                    }
                    if (spriteNum == 2) {
                        img = u2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        img = d1;
                    }
                    if (spriteNum == 2) {
                        img = d2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        img = l1;
                    }
                    if (spriteNum == 2) {
                        img = l2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        img = r1;
                    }
                    if (spriteNum == 2) {
                        img = r2;
                    }
                    break;
            }
            g2.drawImage(img, screenX, screenY, panel.finalTileSize, panel.finalTileSize, null);
        }
    }
}