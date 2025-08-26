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
    public int amountOfCoins = 0;
    boolean hasBlade = false;

    public Player(Panel p, KeyHandler k) {
        super(p);
        this.k = k;
        screenX = p.width / 2 - p.finalTileSize / 2;
        screenY = p.height / 2 - p.finalTileSize / 2;
        defaultValues();
        getPlayerImage();
        bounds = new Rectangle();
        bounds.x = 4;
        bounds.y = 8;
        boundsX = bounds.x;
        boundsY = bounds.y;
        bounds.width = p.finalTileSize - 8;
        bounds.height = p.finalTileSize - 8;
    }

    /**
     * sets the default values for the player
     **/
    public void defaultValues() {
        worldX = p.finalTileSize * 2;
        worldY = p.finalTileSize * 7;
        speed = 8;
        direction = "down";
    }

    /**
     * sets an according player image
     **/
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

    /**
     * updates players direction
     * if the player isn't colliding
     * and due to direction having impact on sprite
     * it changes that too
     **/
    public void update() {
        if (k.up) {
            direction = "up";
        }
        if (k.down) {
            direction = "down";
        }
        if (k.left) {
            direction = "left";
        }
        if (k.right) {
            direction = "right";
        }
        collisionOn = false;
        p.cManager.checkTile(this);
        int itemIndex = p.cManager.checkItem(this, true);
        pickUp(itemIndex);
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

    /**
     * makes the player do an action with an item
     **/
    public void pickUp(int index) {
        if (index != 666) {
            String itemName = p.item[index].name;
            switch (itemName) {
                case "Blade":
                    hasBlade = true;
                    p.item[index] = null;
                    p.ui.showMessage("I have a blade");
                    break;
                case "One_Coin":
                    amountOfCoins++;
                    p.item[index] = null;
                    p.ui.showMessage("I found a coin");
                    break;
                case "Five_Coin":
                    amountOfCoins++;
                    amountOfCoins++;
                    amountOfCoins++;
                    amountOfCoins++;
                    amountOfCoins++;
                    p.item[index] = null;
                    p.ui.showMessage("I was lucky and found 5 coins");
                    break;
                case "SCdoor":
                    if (amountOfCoins >= 100) {
                        p.item[index] = null;
                        p.ui.showMessage("KABOOM! The door has opened");
                    }
                    else p.ui.showMessage("Bonk! The door did not bother to move");
                    break;
                case "Wisdom":
                    p.item[index] = null;
                    p.ui.showMessage("U WON!!!");
                    p.ui.finished = true;
                    break;
            }
        }
    }

    /**
     * draws the player
     **/
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