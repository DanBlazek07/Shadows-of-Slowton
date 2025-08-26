package main;

import entity.Entity;

public class CollisionManager {
    Panel p;

    public CollisionManager(Panel panel) {
        this.p = panel;
    }
    /**
     * checks whether an entity has a collision with the tile
     **/
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.bounds.x;
        int entityRightWorldX = entity.worldX + entity.bounds.x + entity.bounds.width;
        int entityTopWorldY = entity.worldY + entity.bounds.y;
        int entityBottomWorldY = entity.worldY + entity.bounds.y + entity.bounds.height;
        int entityLeftCol = entityLeftWorldX / p.finalTileSize;
        int entityRightCol = entityRightWorldX / p.finalTileSize;
        int entityTopRow = entityTopWorldY / p.finalTileSize;
        int entityBottomRow = entityBottomWorldY / p.finalTileSize;
        int tileNum1, tileNum2;
        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / p.finalTileSize;
                tileNum1 = p.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = p.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (p.tileManager.tiles[tileNum1].collision || p.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / p.finalTileSize;
                tileNum1 = p.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = p.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (p.tileManager.tiles[tileNum1].collision || p.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / p.finalTileSize;
                tileNum1 = p.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = p.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (p.tileManager.tiles[tileNum1].collision || p.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / p.finalTileSize;
                tileNum1 = p.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = p.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (p.tileManager.tiles[tileNum1].collision || p.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
    /**
     * checks whether an entity is colliding with an item, and if it is a player
     **/
    public int checkItem(Entity entity, boolean player) {
        int index = 666;
        for (int i = 0; i < p.item.length; i++) {
            if (p.item[i] != null) {
                entity.bounds.x = entity.worldX + entity.bounds.x;
                entity.bounds.y = entity.worldY + entity.bounds.y;
                p.item[i].bounds.x = p.item[i].worldX + p.item[i].bounds.x;
                p.item[i].bounds.y = p.item[i].worldY + p.item[i].bounds.y;
                switch (entity.direction) {
                    case "up":
                        entity.bounds.y -= entity.speed;
                        if (entity.bounds.intersects(p.item[i].bounds)) {
                            if (p.item[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.bounds.y += entity.speed;
                        if (entity.bounds.intersects(p.item[i].bounds)) {
                            if (p.item[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.bounds.x -= entity.speed;
                        if (entity.bounds.intersects(p.item[i].bounds)) {
                            if (p.item[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.bounds.x += entity.speed;
                        if (entity.bounds.intersects(p.item[i].bounds)) {
                            if (p.item[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.bounds.x = entity.boundsX;
                entity.bounds.y = entity.boundsY;
                p.item[i].bounds.x = p.item[i].boundsX;
                p.item[i].bounds.y = p.item[i].boundsY;
            }
        }
        return index;
    }
    /**
     * checks whether a player is colliding with any entity
     **/
    public int checkEntity(Entity entity, Entity[] target) {
        int index = 666;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                entity.bounds.x = entity.worldX + entity.bounds.x;
                entity.bounds.y = entity.worldY + entity.bounds.y;
                target[i].bounds.x = target[i].worldX + target[i].bounds.x;
                target[i].bounds.y = target[i].worldY + target[i].bounds.y;
                switch (entity.direction) {
                    case "up":
                        entity.bounds.y -= entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                            if (target[i] != entity){
                                entity.collisionOn = true;
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.bounds.y += entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                            if (target[i] != entity){
                                entity.collisionOn = true;
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.bounds.x -= entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                            if (target[i] != entity){
                                entity.collisionOn = true;
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.bounds.x += entity.speed;
                        if (entity.bounds.intersects(target[i].bounds)) {
                            if (target[i] != entity){
                                entity.collisionOn = true;
                                index = i;
                            }
                        }
                        break;
                }
                entity.bounds.x = entity.boundsX;
                entity.bounds.y = entity.boundsY;
                target[i].bounds.x = target[i].boundsX;
                target[i].bounds.y = target[i].boundsY;
            }
        }
        return index;
    }
    /**
     * checks whether an entity is colliding with a player
     **/
    public void checkPlayerCollision(Entity entity) {
        entity.bounds.x = entity.worldX + entity.bounds.x;
        entity.bounds.y = entity.worldY + entity.bounds.y;
        p.player.bounds.x = p.player.worldX + p.player.bounds.x;
        p.player.bounds.y = p.player.worldY + p.player.bounds.y;
        switch (entity.direction) {
            case "up":
                entity.bounds.y -= entity.speed;
                if (entity.bounds.intersects(p.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entity.bounds.y += entity.speed;
                if (entity.bounds.intersects(p.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.bounds.x -= entity.speed;
                if (entity.bounds.intersects(p.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entity.bounds.x += entity.speed;
                if (entity.bounds.intersects(p.player.bounds)) {
                    entity.collisionOn = true;
                }
                break;
        }
        entity.bounds.x = entity.boundsX;
        entity.bounds.y = entity.boundsY;
        p.player.bounds.x = p.player.boundsX;
        p.player.bounds.y = p.player.boundsY;
    }
}