package asset.dynamicEntity.player;

import engine.helpers.ReferenceList;

public class PlayerActions {
    private final Player player;
    private final ReferenceList ref;
    public PlayerActions(Player player, ReferenceList ref) {
        this.player = player;
        this.ref = ref;
    }


    public void movePlayer() {
        if(ref.upPressed) {
            player.worldY = player.worldY - player.moveSpeed;
        }
        if(ref.downPressed) {
            player.worldY = player.worldY + player.moveSpeed;
        }
        if(ref.leftPressed) {
            player.worldX = player.worldX - player.moveSpeed;
        }
        if(ref.rightPressed) {
            player.worldX = player.worldX + player.moveSpeed;
        }
        if(ref.spacePressed) {
            player.worldY = player.worldY - player.jumpHeight;
        }
        if(!player.isSprinting && !player.footstepsSE) {
            if(player.sprintingSE){
                ref.soundEngine.stopSE("footsteps_sprinting");
                player.sprintingSE = false;
            }
            ref.soundEngine.loopSE("footsteps");
            player.footstepsSE = true;
        }
        if(player.isSprinting && !player.sprintingSE){
            if(player.footstepsSE) {
                ref.soundEngine.stopSE("footsteps");
                player.footstepsSE = false;
            }
            ref.soundEngine.loopSE("footsteps_sprinting");
            player.sprintingSE = true;
        }
    }

    public void checkPlayerMovement() {
        if(ref.upPressed){
            player.direction = "up";
            player.isMoving = true;
        }
        if(ref.downPressed){
            player.direction = "down";
            player.isMoving = true;
        }
        if(ref.leftPressed){
            player.direction = "left";
            player.isMoving = true;
        }
        if(ref.rightPressed){
            player.direction = "right";
            player.isMoving = true;
        }
        if(ref.shiftPressed){
            player.spriteCounter++;
            player.isSprinting = true;
            player.moveSpeed = ref.settings.playerSprintSpeed;
        }
        else {
            player.moveSpeed = ref.settings.playerDefaultMoveSpeed;
            player.isSprinting = false;
        }
    }

    public void checkExtraActions() {
        player.collisionOn = false;
        ref.collisionChecker.playerCheckTile(player);

//        String collidedEntity = ref.collisionChecker.checkStaticEntity(player, true);
//        if(collidedEntity != null){
//            player.collisionOn = true;
//        }
    }

}
