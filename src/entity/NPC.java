package entity;

import main.Panel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC extends Entity{
    BufferedImage img;
    public NPC(Panel panel) {
        super(panel);
        getNPCImage();
    }
    public void getNPCImage() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/NPC,enemy/NPC.png"));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
