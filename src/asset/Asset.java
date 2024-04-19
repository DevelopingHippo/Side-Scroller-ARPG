package asset;

import engine.helpers.ReferenceList;

import java.awt.*;
import java.util.UUID;

public class Asset {
    public final String uuid = UUID.randomUUID().toString();
    public String name;
    public int worldX = 0, worldY = 0;
    public Rectangle collisionBox;
    public int collisionBoxDefaultX, collisionBoxDefaultY;

    public int particlesGenerated = 0;
    public int maxParticles = 10;
    public int particleLockCount = 0;
    public boolean particleGenerated = false;


    private final ReferenceList ref;
    public Asset(ReferenceList ref) {
        this.ref = ref;
    }

    public boolean isInPlayerVision() {
        return worldX + ref.settings.tileSize > ref.player.worldX - ref.settings.screenX &&
                worldX - ref.settings.tileSize < ref.player.worldX + ref.settings.screenX &&
                worldY + ref.settings.tileSize > ref.player.worldY - ref.settings.screenX &&
                worldY - ref.settings.tileSize < ref.player.worldY + ref.settings.screenY;
    }


    public void update() {

    }

    public void draw(Graphics2D g2) {

    }
}
