package asset.animation;

import asset.dynamicEntity.player.Player;

import java.awt.image.BufferedImage;

public class PlayerAnimation {

    private final Player player;

    public PlayerAnimation(Player player) {
        this.player = player;
    }


    public BufferedImage walkAnimation3f() {
        BufferedImage image = null;
        switch (player.direction) {
            case "up":
                if (player.spriteNum == 1) { image = player.up1; }
                if (player.spriteNum == 2) { image = player.up2; }
                if (player.spriteNum == 3) { image = player.up1; }
                if (player.spriteNum == 4) { image = player.up3; }
                break;
            case "down":
                if(player.spriteNum == 1) { image = player.down1; }
                if(player.spriteNum == 2) { image = player.down2; }
                if (player.spriteNum == 3) { image = player.down1; }
                if (player.spriteNum == 4) { image = player.down3; }
                break;
            case "left":
                if (player.spriteNum == 1) { image = player.left1; }
                if (player.spriteNum == 2) { image = player.left2; }
                if (player.spriteNum == 3) { image = player.left1; }
                if (player.spriteNum == 4) { image = player.left3; }
                break;
            case "right":
                if (player.spriteNum == 1) { image = player.right1; }
                if (player.spriteNum == 2) { image = player.right2; }
                if (player.spriteNum == 3) { image = player.right1; }
                if (player.spriteNum == 4) { image = player.right3; }
                break;
            case "idle":
                image = player.idle;
        }
        return image;
    }

    public BufferedImage idleAnimation() {
        return switch (player.direction) {
            case "up" -> player.up1;
            case "down" -> player.down1;
            case "left" -> player.left1;
            case "right" -> player.right1;
            case "idle" -> player.idle;
            default -> null;
        };
    }

}
