package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class One_Coin extends Item{
    public One_Coin(){
        name = "One_Coin";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/1coin.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
