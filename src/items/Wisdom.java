package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Wisdom extends Item {
    public Wisdom(){
        name = "Wisdom";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/wisdom.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
