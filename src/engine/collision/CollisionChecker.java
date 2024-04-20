package engine.collision;

import asset.dynamicEntity.DynamicEntity;
import engine.helpers.ReferenceList;

import java.util.Objects;

public class CollisionChecker {

    private final ReferenceList ref;

    public CollisionChecker(ReferenceList ref) {
        this.ref = ref;
    }






    public void playerCheckTile(DynamicEntity entity) {
        int entityLeftWorldX = entity.worldX + entity.collisionBox.x;
        int entityRightWorldX = entity.worldX + entity.collisionBox.x + entity.collisionBox.width;
        int entityTopWorldY = entity.worldY + entity.collisionBox.y;
        int entityBottomWorldY = entity.worldY + entity.collisionBox.y + entity.collisionBox.height;

        int entityLeftCol = entityLeftWorldX / ref.settings.tileSize;
        int entityRightCol = entityRightWorldX / ref.settings.tileSize;
        int entityTopRow = entityTopWorldY / ref.settings.tileSize;
        int entityBottomRow = entityBottomWorldY / ref.settings.tileSize;

        int tileNum1, tileNum2;

        if(ref.upPressed){
            entityTopRow = (entityTopWorldY - entity.moveSpeed) / ref.settings.tileSize;
            tileNum1 = ref.tileManager.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = ref.tileManager.mapTileNum[entityRightCol][entityTopRow];
            if(ref.tileManager.tiles[tileNum1].collidable || ref.tileManager.tiles[tileNum2].collidable) {
                entity.collisionOn = true;
            }
        }
        if(ref.downPressed) {
            entityBottomRow = (entityBottomWorldY + entity.moveSpeed) / ref.settings.tileSize;
            tileNum1 = ref.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = ref.tileManager.mapTileNum[entityRightCol][entityBottomRow];
            if (ref.tileManager.tiles[tileNum1].collidable || ref.tileManager.tiles[tileNum2].collidable) {
                entity.collisionOn = true;
            }
        }
        if(ref.leftPressed) {
            entityLeftCol = (entityLeftWorldX - entity.moveSpeed) / ref.settings.tileSize;
            tileNum1 = ref.tileManager.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = ref.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
            if (ref.tileManager.tiles[tileNum1].collidable || ref.tileManager.tiles[tileNum2].collidable) {
                entity.collisionOn = true;
            }
        }
        if(ref.rightPressed) {
            entityRightCol = (entityRightWorldX + entity.moveSpeed) / ref.settings.tileSize;
            tileNum1 = ref.tileManager.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = ref.tileManager.mapTileNum[entityRightCol][entityBottomRow];
            if (ref.tileManager.tiles[tileNum1].collidable || ref.tileManager.tiles[tileNum2].collidable) {
                entity.collisionOn = true;
            }
        }
    }










    private void checkDirection(DynamicEntity entity) {
        if(Objects.equals(entity.name, "Player")){
            if(ref.upPressed){entity.collisionBox.y -= entity.moveSpeed;}
            if(ref.downPressed){entity.collisionBox.y += entity.moveSpeed;}
            if(ref.leftPressed){entity.collisionBox.x -= entity.moveSpeed;}
            if(ref.rightPressed){entity.collisionBox.x += entity.moveSpeed;}
        }
        else {
            switch(entity.direction) {
                case "up": entity.collisionBox.y -= entity.moveSpeed;break;
                case "down": entity.collisionBox.y += entity.moveSpeed;break;
                case "left": entity.collisionBox.x -= entity.moveSpeed;break;
                case "right": entity.collisionBox.x += entity.moveSpeed;break;
            }
        }
    }
}
