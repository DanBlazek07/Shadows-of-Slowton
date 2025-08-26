package main;

import entity.Enemy;
import entity.NPC;
import items.*;

public class Mapper {
    Panel panel;

    public Mapper(Panel panel) {
        this.panel = panel;
    }

    /**
     * sets the item on the map
     **/
    public void setItem() {
        panel.item[50] = new Blade();
        panel.item[50].worldX = 20 * panel.finalTileSize;
        panel.item[50].worldY = 20 * panel.finalTileSize;
        panel.item[51] = new SCdoor();
        panel.item[51].worldX = 272 * panel.finalTileSize;
        panel.item[51].worldY = 6 * panel.finalTileSize;
        panel.item[51].collision = true;
        panel.item[52] = new SCdoor();
        panel.item[52].worldX = 272 * panel.finalTileSize;
        panel.item[52].worldY = 7 * panel.finalTileSize;
        panel.item[52].collision = true;
        panel.item[53] = new SCdoor();
        panel.item[53].worldX = 272 * panel.finalTileSize;
        panel.item[53].worldY = 4 * panel.finalTileSize;
        panel.item[53].collision = true;
        panel.item[54] = new SCdoor();
        panel.item[54].worldX = 272 * panel.finalTileSize;
        panel.item[54].worldY = 5 * panel.finalTileSize;
        panel.item[54].collision = true;
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
        panel.item[6].worldX = 118 * panel.finalTileSize;
        panel.item[6].worldY = 20 * panel.finalTileSize;
        panel.item[7] = new Five_Coin();
        panel.item[7].worldX = 118 * panel.finalTileSize;
        panel.item[7].worldY = 21 * panel.finalTileSize;
        panel.item[8] = new Five_Coin();
        panel.item[8].worldX = 119 * panel.finalTileSize;
        panel.item[8].worldY = 21 * panel.finalTileSize;
        panel.item[9] = new Five_Coin();
        panel.item[9].worldX = 119 * panel.finalTileSize;
        panel.item[9].worldY = 20 * panel.finalTileSize;
        panel.item[10] = new Five_Coin();
        panel.item[10].worldX = 109 * panel.finalTileSize;
        panel.item[10].worldY = 15 * panel.finalTileSize;
        panel.item[11] = new Five_Coin();
        panel.item[11].worldX = 109 * panel.finalTileSize;
        panel.item[11].worldY = 14 * panel.finalTileSize;
        panel.item[12] = new Five_Coin();
        panel.item[12].worldX = 156 * panel.finalTileSize;
        panel.item[12].worldY = 20 * panel.finalTileSize;
        panel.item[13] = new Five_Coin();
        panel.item[13].worldX = 157 * panel.finalTileSize;
        panel.item[13].worldY = 20 * panel.finalTileSize;
        panel.item[14] = new Five_Coin();
        panel.item[14].worldX = 157 * panel.finalTileSize;
        panel.item[14].worldY = 21 * panel.finalTileSize;
        panel.item[15] = new Five_Coin();
        panel.item[15].worldX = 156 * panel.finalTileSize;
        panel.item[15].worldY = 21 * panel.finalTileSize;
        panel.item[16] = new Five_Coin();
        panel.item[16].worldX = 143 * panel.finalTileSize;
        panel.item[16].worldY = 15 * panel.finalTileSize;
        panel.item[17] = new Five_Coin();
        panel.item[17].worldX = 143 * panel.finalTileSize;
        panel.item[17].worldY = 14 * panel.finalTileSize;
        panel.item[18] = new Five_Coin();
        panel.item[18].worldX = 142 * panel.finalTileSize;
        panel.item[18].worldY = 15 * panel.finalTileSize;
        panel.item[19] = new Five_Coin();
        panel.item[19].worldX = 142 * panel.finalTileSize;
        panel.item[19].worldY = 14 * panel.finalTileSize;
        panel.item[0] = new Five_Coin();
        panel.item[0].worldX = 110 * panel.finalTileSize;
        panel.item[0].worldY = 21 * panel.finalTileSize;
        panel.item[1] = new Five_Coin();
        panel.item[1].worldX = 82 * panel.finalTileSize;
        panel.item[1].worldY = 19 * panel.finalTileSize;
        panel.item[350] = new One_Coin();
        panel.item[350].worldX = 251 * panel.finalTileSize;
        panel.item[350].worldY = 20 * panel.finalTileSize;
        panel.item[69] = new Wisdom();
        panel.item[69].worldX = 347 * panel.finalTileSize;
        panel.item[69].worldY = 11 * panel.finalTileSize;
    }

    /**
     * sets the NPC somewhere on the map
     **/
    public void setNPC() {
        panel.npc[0] = new NPC(panel);
        panel.npc[0].worldX = 2 * panel.finalTileSize;
        panel.npc[0].worldY = 8 * panel.finalTileSize;
        panel.npc[1] = new NPC(panel);
        panel.npc[1].worldX = 132 * panel.finalTileSize;
        panel.npc[1].worldY = 15 * panel.finalTileSize;
        panel.npc[2] = new NPC(panel);
        panel.npc[2].worldX = 284 * panel.finalTileSize;
        panel.npc[2].worldY = 13 * panel.finalTileSize;
        panel.npc[3] = new NPC(panel);
        panel.npc[3].worldX = 284 * panel.finalTileSize;
        panel.npc[3].worldY = 11 * panel.finalTileSize;
        panel.npc[4] = new NPC(panel);
        panel.npc[4].worldX = 344 * panel.finalTileSize;
        panel.npc[4].worldY = 9 * panel.finalTileSize;
        panel.npc[5] = new NPC(panel);
        panel.npc[5].worldX = 344 * panel.finalTileSize;
        panel.npc[5].worldY = 13 * panel.finalTileSize;
    }

    /**
     * sets the enemy on the map somewhere
     **/
    public void setEnemy() {
        panel.enemy[0] = new Enemy(panel);
        panel.enemy[0].worldX = 59 * panel.finalTileSize;
        panel.enemy[0].worldY = 15 * panel.finalTileSize;
        panel.enemy[1] = new Enemy(panel);
        panel.enemy[1].worldX = 132 * panel.finalTileSize;
        panel.enemy[1].worldY = 14 * panel.finalTileSize;
        panel.enemy[2] = new Enemy(panel);
        panel.enemy[2].worldX = 131 * panel.finalTileSize;
        panel.enemy[2].worldY = 15 * panel.finalTileSize;
        panel.enemy[3] = new Enemy(panel);
        panel.enemy[3].worldX = 241 * panel.finalTileSize;
        panel.enemy[3].worldY = 16 * panel.finalTileSize;
        panel.enemy[4] = new Enemy(panel);
        panel.enemy[4].worldX = 241 * panel.finalTileSize;
        panel.enemy[4].worldY = 17 * panel.finalTileSize;
        panel.enemy[5] = new Enemy(panel);
        panel.enemy[5].worldX = 241 * panel.finalTileSize;
        panel.enemy[5].worldY = 18 * panel.finalTileSize;
        panel.enemy[6] = new Enemy(panel);
        panel.enemy[6].worldX = 244 * panel.finalTileSize;
        panel.enemy[6].worldY = 20 * panel.finalTileSize;
        panel.enemy[7] = new Enemy(panel);
        panel.enemy[7].worldX = 243 * panel.finalTileSize;
        panel.enemy[7].worldY = 20 * panel.finalTileSize;
        panel.enemy[8] = new Enemy(panel);
        panel.enemy[8].worldX = 243 * panel.finalTileSize;
        panel.enemy[8].worldY = 14 * panel.finalTileSize;
        panel.enemy[9] = new Enemy(panel);
        panel.enemy[9].worldX = 244 * panel.finalTileSize;
        panel.enemy[9].worldY = 14 * panel.finalTileSize;
        panel.enemy[10] = new Enemy(panel);
        panel.enemy[10].worldX = 245 * panel.finalTileSize;
        panel.enemy[10].worldY = 14 * panel.finalTileSize;
        panel.enemy[11] = new Enemy(panel);
        panel.enemy[11].worldX = 246 * panel.finalTileSize;
        panel.enemy[11].worldY = 14 * panel.finalTileSize;
        panel.enemy[12] = new Enemy(panel);
        panel.enemy[12].worldX = 247 * panel.finalTileSize;
        panel.enemy[12].worldY = 14 * panel.finalTileSize;
        panel.enemy[13] = new Enemy(panel);
        panel.enemy[13].worldX = 248 * panel.finalTileSize;
        panel.enemy[13].worldY = 14 * panel.finalTileSize;
        panel.enemy[14] = new Enemy(panel);
        panel.enemy[14].worldX = 249 * panel.finalTileSize;
        panel.enemy[14].worldY = 14 * panel.finalTileSize;
        panel.enemy[15] = new Enemy(panel);
        panel.enemy[15].worldX = 245 * panel.finalTileSize;
        panel.enemy[15].worldY = 20 * panel.finalTileSize;
        panel.enemy[16] = new Enemy(panel);
        panel.enemy[16].worldX = 246 * panel.finalTileSize;
        panel.enemy[16].worldY = 20 * panel.finalTileSize;
        panel.enemy[17] = new Enemy(panel);
        panel.enemy[17].worldX = 247 * panel.finalTileSize;
        panel.enemy[17].worldY = 20 * panel.finalTileSize;
        panel.enemy[18] = new Enemy(panel);
        panel.enemy[18].worldX = 248 * panel.finalTileSize;
        panel.enemy[18].worldY = 20 * panel.finalTileSize;
        panel.enemy[19] = new Enemy(panel);
        panel.enemy[19].worldX = 249 * panel.finalTileSize;
        panel.enemy[19].worldY = 20 * panel.finalTileSize;
        panel.enemy[20] = new Enemy(panel);
        panel.enemy[20].worldX = 251 * panel.finalTileSize;
        panel.enemy[20].worldY = 16 * panel.finalTileSize;
        panel.enemy[21] = new Enemy(panel);
        panel.enemy[21].worldX = 251 * panel.finalTileSize;
        panel.enemy[21].worldY = 18 * panel.finalTileSize;
        panel.enemy[22] = new Enemy(panel);
        panel.enemy[22].worldX = 324 * panel.finalTileSize;
        panel.enemy[22].worldY = 13 * panel.finalTileSize;
        panel.enemy[23] = new Enemy(panel);
        panel.enemy[23].worldX = 324 * panel.finalTileSize;
        panel.enemy[23].worldY = 9 * panel.finalTileSize;
    }
}