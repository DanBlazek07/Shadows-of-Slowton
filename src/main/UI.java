package main;

import items.One_Coin;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    Panel panel;
    Font arial48;
    BufferedImage coin;
    public boolean canMessage = false;
    public String message;
    int msgCounter = 0;
    public boolean finished = false;

    public UI(Panel p) {
        panel = p;
        arial48 = new Font("Arial", Font.PLAIN, 48);
        One_Coin oc = new One_Coin();
        coin = oc.image;
    }
    /**
     * shows a message on the screen
     **/
    public void showMessage(String msg) {
        message = msg;
        canMessage = true;
    }
    /**
     * draws the message on the screen
     **/
    public void draw(Graphics2D g2) {
        if (finished){
            g2.setFont(arial48);
            g2.setColor(Color.CYAN);
            String text;
            int txtLength;
            int halfWidth;
            int halfHeight;
            text = "all your wisdom is back...";
            txtLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            halfWidth = panel.width/2 - txtLength/2;
            halfHeight = panel.height/2 - (panel.finalTileSize*3);
            g2.drawString(text,halfWidth,halfHeight);
            panel.game = null;
        }else {
            g2.setFont(arial48);
            g2.setColor(Color.CYAN);
            g2.drawImage(coin, 20, 20, panel.finalTileSize, panel.finalTileSize, null);
            g2.drawString(": " + panel.player.amountOfCoins, 70, 58);
            if (canMessage) {
                g2.drawString(message, panel.finalTileSize/2, 14* panel.finalTileSize);
                msgCounter++;
                if (msgCounter > 120) {
                    msgCounter = 0;
                    canMessage = false;
                }
            }
        }
    }
}
