package main;

import entity.NPC;
import items.*;

public class Mapper {
    Panel panel;

    public Mapper(Panel panel) {
        this.panel = panel;
    }

    public void setObject() {
        panel.item[0] = new Blade();
        panel.item[0].worldX = 20 * panel.finalTileSize;
        panel.item[0].worldY = 20 * panel.finalTileSize;
        panel.item[1] = new SCdoor();
        panel.item[1].worldX = 15 * panel.finalTileSize;
        panel.item[1].worldY = 15 * panel.finalTileSize;
        panel.item[1].collision = true;
        panel.item[2] = new Five_Coin();
        panel.item[2].worldX = 31 * panel.finalTileSize;
        panel.item[2].worldY = 19 * panel.finalTileSize;
        panel.item[3] = new Five_Coin();
        panel.item[3].worldX = 31 * panel.finalTileSize;
        panel.item[3].worldY = 19 * panel.finalTileSize;
        panel.item[4] = new Five_Coin();
        panel.item[4].worldX = 31 * panel.finalTileSize;
        panel.item[4].worldY = 19 * panel.finalTileSize;
        panel.item[5] = new Five_Coin();
        panel.item[5].worldX = 31 * panel.finalTileSize;
        panel.item[5].worldY = 19 * panel.finalTileSize;
        panel.item[6] = new Five_Coin();
        panel.item[6].worldX = 31 * panel.finalTileSize;
        panel.item[6].worldY = 19 * panel.finalTileSize;
        panel.item[7] = new Five_Coin();
        panel.item[7].worldX = 31 * panel.finalTileSize;
        panel.item[7].worldY = 19 * panel.finalTileSize;
        panel.item[8] = new Five_Coin();
        panel.item[8].worldX = 31 * panel.finalTileSize;
        panel.item[8].worldY = 19 * panel.finalTileSize;
        panel.item[9] = new Five_Coin();
        panel.item[9].worldX = 31 * panel.finalTileSize;
        panel.item[9].worldY = 19 * panel.finalTileSize;
        panel.item[10] = new Five_Coin();
        panel.item[10].worldX = 31 * panel.finalTileSize;
        panel.item[10].worldY = 19 * panel.finalTileSize;
        panel.item[11] = new Five_Coin();
        panel.item[11].worldX = 31 * panel.finalTileSize;
        panel.item[11].worldY = 19 * panel.finalTileSize;
        panel.item[12] = new Five_Coin();
        panel.item[12].worldX = 31 * panel.finalTileSize;
        panel.item[12].worldY = 19 * panel.finalTileSize;
        panel.item[13] = new Five_Coin();
        panel.item[13].worldX = 31 * panel.finalTileSize;
        panel.item[13].worldY = 19 * panel.finalTileSize;
        panel.item[14] = new Five_Coin();
        panel.item[14].worldX = 31 * panel.finalTileSize;
        panel.item[14].worldY = 19 * panel.finalTileSize;
        panel.item[15] = new Five_Coin();
        panel.item[15].worldX = 31 * panel.finalTileSize;
        panel.item[15].worldY = 19 * panel.finalTileSize;
        panel.item[16] = new Five_Coin();
        panel.item[16].worldX = 31 * panel.finalTileSize;
        panel.item[16].worldY = 19 * panel.finalTileSize;
        panel.item[17] = new Five_Coin();
        panel.item[17].worldX = 31 * panel.finalTileSize;
        panel.item[17].worldY = 19 * panel.finalTileSize;
        panel.item[18] = new Five_Coin();
        panel.item[18].worldX = 31 * panel.finalTileSize;
        panel.item[18].worldY = 19 * panel.finalTileSize;
        panel.item[19] = new Five_Coin();
        panel.item[19].worldX = 31 * panel.finalTileSize;
        panel.item[19].worldY = 19 * panel.finalTileSize;
        panel.item[20] = new Five_Coin();
        panel.item[20].worldX = 31 * panel.finalTileSize;
        panel.item[20].worldY = 19 * panel.finalTileSize;
        panel.item[21] = new Five_Coin();
        panel.item[21].worldX = 82 * panel.finalTileSize;
        panel.item[21].worldY = 19 * panel.finalTileSize;
        panel.item[63] = new Wisdom();
        panel.item[63].worldX = 80 * panel.finalTileSize;
        panel.item[63].worldY = 19 * panel.finalTileSize;
    }
    public void setNPC(){
        panel.npc[0] = new NPC(panel);
        panel.npc[0].worldX = 2*panel.finalTileSize;
        panel.npc[0].worldY = 8 * panel.finalTileSize;
    }
    public void setEnemy(){

    }
}