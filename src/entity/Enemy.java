package entity;

import main.Panel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends Entity{
    int hp = 20;
    BufferedImage img;
    public Enemy(Panel panel) {
        super(panel);
    }
    public void getEnemyImage(){
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/NPC,enemy/sprite.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
