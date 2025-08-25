package entity;

import main.KeyHandler;
import main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    Panel p;
    KeyHandler k;
    public final int screenX;
    public final int screenY;

    public Player(Panel p, KeyHandler k) {
        this.p = p;
        this.k = k;
        defaultV();
        getPlayerImage();
        screenX = p.width/2 - p.finalTileSize/2;
        screenY = p.height/2 - p.finalTileSize/2;
    }

    public void defaultV() {
        worldX = p.finalTileSize * 2;
        worldY = p.finalTileSize * 7;
        speed = 8;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            u1 = ImageIO.read(getClass().getResourceAsStream("/player/pu1.png"));
            u2 = ImageIO.read(getClass().getResourceAsStream("/player/pu2.png"));
            d1 = ImageIO.read(getClass().getResourceAsStream("/player/pd1.png"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/player/pd2.png"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/player/pl1.png"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/player/pl2.png"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/player/pp1.png"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/player/pp2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if (k.up) {
            direction = "up";
            worldY -= speed;
        }
        if (k.down) {
            direction = "down";
            worldY += speed;
        }
        if (k.left) {
            direction = "left";
            worldX -= speed;
        }
        if (k.right) {
            direction = "right";
            worldX += speed;
        }
        spriteCount++;
        if (spriteCount > 10) {
            if (spriteNum == 1){
                spriteNum = 2;
            }
            else if (spriteNum == 2){
                spriteNum = 1;
            }
            spriteCount = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage img = null;
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
        g2.drawImage(img, screenX, screenY, p.finalTileSize, p.finalTileSize, null);
    }
}