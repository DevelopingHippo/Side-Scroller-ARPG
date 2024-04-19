package engine.helpers;


import engine.AssetManager;
import engine.Engine;
import engine.collision.CollisionChecker;
import engine.graphics.Renderer;
import engine.graphics.UI;
import engine.io.UserControls;
import engine.level.Tile.TileManager;
import engine.soundEngine.SoundEngine;
import asset.dynamicEntity.player.Player;
import engine.level.*;

public class ReferenceList {
    public Engine engine = new Engine(this);
    public Renderer renderer = new Renderer(this);
    public Settings settings = new Settings();
    public UserControls userControls = new UserControls(this);
    public AssetManager assetManager = new AssetManager(this);
    public LevelManager levelManager = new LevelManager(this);
    public TileManager tileManager = new TileManager(this);
    public SoundEngine soundEngine = new SoundEngine(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
//    public ParticleGenerator particleGenerator = new ParticleGenerator(this);
    public UI ui = new UI(this);

    public Player player = new Player(this);

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, spacePressed, shiftPressed, ePressed, fPressed;

}
