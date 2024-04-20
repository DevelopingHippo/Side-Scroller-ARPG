package engine.level;

import engine.helpers.ReferenceList;

public class LevelManager {
    private final ReferenceList ref;

    public String level_1_filePath = "/World/Levels/level_1.txt";
    public String tile_data_path = "/World/Tiles/data/tiledata.txt";
    public int maxWorldCol = 30;
    public int maxWorldRow = 30;

    public LevelManager(ReferenceList ref) {
        this.ref = ref;
    }
}
