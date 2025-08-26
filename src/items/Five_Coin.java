package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Five_Coin extends Item{
    public Five_Coin(){
        name = "Five_Coin";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/5coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}