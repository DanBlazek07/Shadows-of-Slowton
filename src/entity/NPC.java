package entity;

import main.Panel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC extends Entity {
    public NPC(Panel panel) {
        super(panel);
        direction = "down";
        speed = 8;
        getNPCImage();
    }

    public void getNPCImage() {
        try {
            u1 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCu1.png"));
            u2 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCu2.png"));
            d1 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCd1.png"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCd2.png"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCr1.png"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCr2.png"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCl1.png"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/entities/NPCl2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void action() {
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
