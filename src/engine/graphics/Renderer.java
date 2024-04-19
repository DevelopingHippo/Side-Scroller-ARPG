package engine.graphics;

import asset.Asset;
import asset.dynamicEntity.particle.Particle;
import engine.helpers.ReferenceList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Renderer {

    private final ReferenceList ref;
    private final ArrayList<Asset> renderAssetList = new ArrayList<>();
    private Iterator<Asset> assetListIter;


    public Renderer(ReferenceList referenceList) {
        this.ref = referenceList;
    }

    public void render(Graphics2D g2) {
        ref.tileManager.draw(g2);


        // Add Assets to Render List
//        for(Asset asset : ref.assetManager.getAllAssets()) {
//            if(asset != null){
//                renderAssetList.add(asset);
//            }
//        }
//        for(Asset asset : renderAssetList){
//            asset.draw(g2);
//        }
//
//        for(Particle particle : ref.assetManager.getParticleList()){
//            particle.draw(g2);
//        }


        ref.player.draw(g2);
        ref.ui.draw(g2);

        renderAssetList.clear();

        g2.dispose();
    }
}
