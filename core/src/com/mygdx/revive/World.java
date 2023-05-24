package com.mygdx.revive;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

///import static com.mygdx.revive.state.GameState.PAUSING;
//import static com.mygdx.revive.state.GameState.PLAYING;

public class World implements Renderable {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final Texture BACKGROUND_TEXTURE = new Texture(Gdx.files.internal("badlogic.jpg"));
    //private static final Texture LOGO_TEXTURE = new Texture(Gdx.files.internal("logo.png"));
    //private static final Music BGM_SOUND = Gdx.audio.newMusic(Gdx.files.internal("audio/BGM.mp3"));

    public SpriteBatch batch;
    public BitmapFont font;
    //private Player player;
    //private final OrthographicCamera camera;
    //private final ShapeRenderer shapeRenderer;
    private Texture background;
    //private GameState gameState;
    private boolean debug;

    public World(SpriteBatch batch) {
        //this.gameSetting = new GameSetting();
        this.batch = batch;
        //this.scheduler = new Scheduler();

        this.font = new BitmapFont(Gdx.files.internal("fonts/default.fnt"),
                new TextureRegion(new Texture(Gdx.files.internal("fonts/default.png"))));
        //this.textIndicator = new TextIndicator(this);
        //this.camera = new OrthographicCamera(800, 600);
        //this.shapeRenderer = new ShapeRenderer();
        //this.gameState = GameState.STARTING;
        //this.hud = new HUD(this);
        //this.debug = false;
        //this.inventory = new Inventory(this);
    }

    @Override
    public void create () {
    }

    @Override
    public void render () {
    }


    @Override
    public void dispose () {
    }
}



