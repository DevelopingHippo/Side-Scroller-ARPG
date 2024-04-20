package engine;

import engine.helpers.ReferenceList;
import asset.dynamicEntity.particle.Particle;

import java.util.Iterator;

public class Engine {

    private Iterator<Particle> iterParticle;


    private final ReferenceList ref;
    public Engine(ReferenceList ref) {
        this.ref = ref;
    }


    public void setup() {
//        ref.assetManager.spawnAsset("Old Man", 27, 13);
//        ref.assetManager.spawnAsset("Door", 11, 27);
//        ref.assetManager.spawnAsset("Dan", 20, 241);
//        ref.assetManager.spawnAsset("Ollie", 26, 11);
//        ref.assetManager.spawnStairs(12, 21, 12, 238);

        ref.soundEngine.playMusic("backgroundMusic");
        ref.soundEngine.playEnvironment("Forest_Day");
    }


    public void update() {
        ref.player.update();

//        for(Asset asset : ref.assetManager.getAllAssets()){
//            if(asset != null) {
//                asset.update();
//            }
//        }
//        iterParticle = ref.assetManager.getParticleList().iterator();
//        while (iterParticle.hasNext()) {
//            Particle particle = iterParticle.next();
//            if (particle != null) {
//                if (particle.isAlive) {
//                    particle.update();
//                }
//                else {
//                    iterParticle.remove();
//                }
//            }
//        }
    }

}
