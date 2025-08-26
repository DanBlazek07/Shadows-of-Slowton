package entity;

import main.Panel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Enemy extends Entity{

    public Enemy(Panel panel) {
        super(panel);
        direction = "right";
        speed = 6;
        maxLife = 20;
        currentLife = maxLife;
        getEnemyImage();
    }

    public void getEnemyImage(){
        try{
            u1 = ImageIO.read(getClass().getResourceAsStream("/entities/ed1.png"));
            u2 = ImageIO.read(getClass().getResourceAsStream("/entities/ed2.png"));
            d1 = ImageIO.read(getClass().getResourceAsStream("/entities/er1.png"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/entities/er2.png"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/entities/el1.png"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/entities/el2.png"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/entities/er1.png"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/entities/er2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void action(){
        actionLockCounter++;
        if (actionLockCounter == 120) {
            Random rnd = new Random();
            int i = rnd.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }
}