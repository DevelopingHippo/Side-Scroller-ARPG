package asset.dynamicEntity.player;

import asset.dynamicEntity.DynamicEntity;
import engine.helpers.ReferenceList;

import java.awt.*;

public class Player extends DynamicEntity {

    private PlayerHelpers helpers;
    private PlayerActions actions;
    public Player(ReferenceList ref) {
        super(ref);
        helpers = new PlayerHelpers(this, ref);
        actions = new PlayerActions(this, ref);
    }






    public void moveDynamicEntity() {
        switch (direction) {
            case "up":
                worldY = worldY - moveSpeed;
                break;
            case "down":
                worldY = worldY + moveSpeed;
                break;
            case "left":
                worldX = worldX - moveSpeed;
                break;
            case "right":
                worldX = worldX + moveSpeed;
                break;
        }
    }

    public void update() {

    }


    public void draw(Graphics2D g2) {


    }
}
