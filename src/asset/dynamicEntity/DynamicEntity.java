package asset.dynamicEntity;

import asset.Asset;
import asset.animation.Animation;
import engine.helpers.ReferenceList;

import java.awt.image.BufferedImage;

public class DynamicEntity extends Asset {

    public int moveSpeed = 1;
    public BufferedImage idle, up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public BufferedImage  up_fishing1, up_fishing2, down_fishing1, down_fishing2, left_fishing1, left_fishing2, right_fishing1, right_fishing2;
    public BufferedImage receiveGoldfish;
    public String direction = "idle";
    public Animation animation = new Animation(this);
    public boolean isMoving = false;
    public int spriteNum = 1;
    public int spriteCounter = 0;
    public int spriteFrameTime = 36;
    public boolean collisionOn = false;

    public DynamicEntity(ReferenceList ref) {
        super(ref);
    }

    public void animationFrames() {
        spriteCounter++;
        if (spriteCounter > spriteFrameTime) {
            if(spriteNum == 4){
                spriteNum = 0;
            }
            spriteNum++;
            spriteCounter = 0;
        }
    }


}
