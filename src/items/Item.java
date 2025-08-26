package items;

import main.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle bounds = new Rectangle(0,0,48,48);
    public int boundsX,boundsY = 0;
    public void draw(Graphics2D g2, Panel p) {
        int screenX = worldX - p.player.worldX + p.player.screenX;
        int screenY = worldY - p.player.worldY + p.player.screenY;
        if (worldX + p.finalTileSize > p.player.worldX - p.player.screenX &&
                worldX - p.finalTileSize < p.player.worldX + p.player.screenX &&
                worldY + p.finalTileSize > p.player.worldY - p.player.screenY &&
                worldY - p.finalTileSize < p.player.worldY + p.player.screenY) {
            g2.drawImage(image, screenX, screenY, p.finalTileSize, p.finalTileSize, null);
        }
    }
}