package asset.dynamicEntity.player;

import asset.animation.PlayerAnimation;
import asset.dynamicEntity.DynamicEntity;
import engine.helpers.ReferenceList;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends DynamicEntity {

    private PlayerHelpers helpers;
    private PlayerActions actions;

    public boolean isSprinting = false;
    public boolean footstepsSE = false;
    public boolean sprintingSE = false;
    public boolean interacted = false;
    public int jumpHeight = 5;
    private final PlayerAnimation animation = new PlayerAnimation(this);

    public Player(ReferenceList ref) {
        super(ref);
        helpers = new PlayerHelpers(this, ref);
        actions = new PlayerActions(this, ref);
        worldX = ref.settings.playerDefaultWorldX * ref.settings.tileSize;
        worldY = ref.settings.playerDefaultWorldY * ref.settings.tileSize;
        collisionBoxDefaultX = 8;
        collisionBoxDefaultY = 20;
        collisionBox = new Rectangle(collisionBoxDefaultX, collisionBoxDefaultY, (int) (ref.settings.tileSize / 1.5), ref.settings.tileSize / 2);
        helpers.getPlayerImages();
    }


    private void gravity() {

        worldY++;

    }

    public void update() {
        isMoving = false;
        animationFrames();
        collisionOn = false;
        if(ref.upPressed || ref.downPressed || ref.leftPressed || ref.rightPressed || ref.spacePressed) {
            actions.checkPlayerMovement();
            actions.checkExtraActions();
            if(!collisionOn){
                gravity();
            }
            if(!collisionOn) {
                actions.movePlayer();
            }
        }
        else {
            if(footstepsSE){
                ref.soundEngine.stopSE("footsteps");
                footstepsSE = false;
            }
            if(sprintingSE) {
                ref.soundEngine.stopSE("footsteps_sprinting");
                sprintingSE = false;
            }
        }
    }


    public void draw(Graphics2D g2) {
        BufferedImage image = idle;
        int tempScreenX = ref.settings.screenX;
        int tempScreenY = ref.settings.screenY;

        if(isMoving) {
            image = animation.walkAnimation3f();
        }
        else {
            image = animation.idleAnimation();
        }

        g2.drawImage(image, tempScreenX, tempScreenY, null);
        if(ref.settings.debug){
            g2.setColor(Color.red);
            g2.drawRect(collisionBox.x + tempScreenX, collisionBox.y + tempScreenY, collisionBox.width, collisionBox.height);
        }
    }
}
