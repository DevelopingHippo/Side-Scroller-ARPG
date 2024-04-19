package asset.dynamicEntity.player;

import engine.helpers.ReferenceList;
import engine.helpers.Utils;

public class PlayerHelpers {

    private final Player player;
    private final ReferenceList ref;
    public PlayerHelpers(Player player, ReferenceList ref) {
        this.player = player;
        this.ref = ref;
    }


    public void getPlayerImages() {
        player.up1 = Utils.setupImage("/Images/Assets/Player/Walking/up1", ref.settings.tileSize, ref.settings.tileSize);
        player.up2 = Utils.setupImage("/Images/Assets/Player/Walking/up2", ref.settings.tileSize, ref.settings.tileSize);
        player.up3 = Utils.setupImage("/Images/Assets/Player/Walking/up3", ref.settings.tileSize, ref.settings.tileSize);

        player.down1 = Utils.setupImage("/Images/Assets/Player/Walking/down1", ref.settings.tileSize, ref.settings.tileSize);
        player.down2 = Utils.setupImage("/Images/Assets/Player/Walking/down2", ref.settings.tileSize, ref.settings.tileSize);
        player.down3 = Utils.setupImage("/Images/Assets/Player/Walking/down3", ref.settings.tileSize, ref.settings.tileSize);

        player.left1 = Utils.setupImage("/Images/Assets/Player/Walking/left1", ref.settings.tileSize, ref.settings.tileSize);
        player.left2 = Utils.setupImage("/Images/Assets/Player/Walking/left2", ref.settings.tileSize, ref.settings.tileSize);
        player.left3 = Utils.setupImage("/Images/Assets/Player/Walking/left3", ref.settings.tileSize, ref.settings.tileSize);

        player.right1 = Utils.setupImage("/Images/Assets/Player/Walking/right1", ref.settings.tileSize, ref.settings.tileSize);
        player.right2 = Utils.setupImage("/Images/Assets/Player/Walking/right2", ref.settings.tileSize, ref.settings.tileSize);
        player.right3 = Utils.setupImage("/Images/Assets/Player/Walking/right3", ref.settings.tileSize, ref.settings.tileSize);

        player.idle = player.down1;
    }



    public void animationFrames() {
        player.spriteCounter++;
        if (player.spriteCounter > player.spriteFrameTime) {
            if(player.spriteNum == 4){
                player.spriteNum = 0;
            }
            player.spriteNum++;
            player.spriteCounter = 0;
        }
    }
}
