package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Blade extends Item {

    int dealsHP = 5;

    public Blade(){
        name = "Blade";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/blade.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
