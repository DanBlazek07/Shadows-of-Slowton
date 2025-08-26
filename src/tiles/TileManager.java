package tiles;

import main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    Panel panel;
    public Tile[] tiles;
    public int[][] mapTileNum;

    public TileManager(Panel panel) {
        this.panel = panel;
        tiles = new Tile[7];
        mapTileNum = new int[panel.maxWorldCol][panel.maxWorldRow];
        getTileImage();
        loadMap("/maps/worldMap.txt");
    }
    /**
     * chooses the tile image and if it has a collision or not
     **/
    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tiles[1].collision = true;
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tiles[2].collision = true;
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/path.png"));
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stone.png"));
            tiles[4].collision = true;
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood.png"));
            tiles[5].collision = true;
            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/plank.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * loads the entire map
     **/
    public void loadMap(String fileName){
        try {
            InputStream is = getClass().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < panel.maxWorldCol && row < panel.maxWorldRow) {
                String line = br.readLine();
                while (col < panel.maxWorldCol) {
                    String[] split = line.split(" ");
                    int num = Integer.parseInt(split[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == panel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * draws the tiles
     **/
    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < panel.maxWorldCol && worldRow < panel.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * panel.finalTileSize;
            int worldY = worldRow * panel.finalTileSize;
            int screenX = worldX - panel.player.worldX + panel.player.screenX;
            int screenY = worldY - panel.player.worldY + panel.player.screenY;
            if (worldX + panel.finalTileSize > panel.player.worldX - panel.player.screenX &&
                    worldX - panel.finalTileSize < panel.player.worldX + panel.player.screenX &&
                    worldY + panel.finalTileSize > panel.player.worldY - panel.player.screenY &&
                    worldY - panel.finalTileSize < panel.player.worldY + panel.player.screenY) {
                g2.drawImage(tiles[tileNum].image, screenX, screenY, panel.finalTileSize, panel.finalTileSize, null);
            }

            worldCol++;
            if (worldCol == panel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}