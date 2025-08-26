package items;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SCdoor extends Item {
    public SCdoor(){
        name = "SCdoor";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/SCdoor.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
