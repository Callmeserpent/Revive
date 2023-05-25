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
import com.mygdx.revive.effects.TextIndicator;
import com.mygdx.revive.location.Location;
import com.mygdx.revive.location.Vector2D;
import com.mygdx.revive.state.GameState;
import com.mygdx.revive.hud.HUD;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static com.mygdx.revive.state.GameState.PAUSING;
import static com.mygdx.revive.state.GameState.PLAYING;

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
    private GameState gameState;
    private boolean debug;

    private final TextIndicator textIndicator;
    private final HUD hud;

    public World(SpriteBatch batch) {
        //this.gameSetting = new GameSetting();
        this.batch = batch;
        //this.scheduler = new Scheduler();

        this.font = new BitmapFont(Gdx.files.internal("fonts/default.fnt"),
                new TextureRegion(new Texture(Gdx.files.internal("fonts/default.png"))));
        this.textIndicator = new TextIndicator(this);
        //this.camera = new OrthographicCamera(800, 600);
        //this.shapeRenderer = new ShapeRenderer();
        this.gameState = GameState.STARTING;
        this.hud = new HUD(this);
        //this.debug = false;
        //this.inventory = new Inventory(this);
    }

    @Override
    public void create() {
    }

    @Override
    public void render() {

        // Render HUD
        switch (this.gameState) {
            case STARTING: {
                Gdx.app.log("Game Status", "Starting status");

                // Render logo
                //this.batch.draw(LOGO_TEXTURE, 29, (386));

                // Register press to start
                this.font.draw(this.batch,
                        "Press LEFT MOUSE key to start",
                        300,
                        320,
                        200,
                        Align.center,
                        true);

                // Register keyboard for starting
                Gdx.input.setInputProcessor(new InputProcessor() {
                    @Override
                    public boolean keyDown(int keycode) {
                        if (keycode == Input.Buttons.LEFT) {
                            // The game still running
                            if (getGameState() == GameState.STARTING) {
                                setGameState(PLAYING);
                            }

                            return true;
                        }
                        return false;
                    }

                    @Override
                    public boolean keyUp(int keycode) {
                        return false;
                    }

                    @Override
                    public boolean keyTyped(char character) {
                        return false;
                    }

                    @Override
                    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                        if (button == Input.Buttons.LEFT) {
                            // The game still running
                            if (getGameState() == GameState.STARTING) {
                                setGameState(PLAYING);
                            }
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                        return false;
                    }

                    @Override
                    public boolean touchDragged(int screenX, int screenY, int pointer) {
                        return false;
                    }

                    @Override
                    public boolean mouseMoved(int screenX, int screenY) {
                        return false;
                    }

                    @Override
                    public boolean scrolled(float amountX, float amountY) {
                        return false;
                    }
                });

                break;
            }
            case PAUSING:
            case ENDING:
            case PLAYING: {
                // Render player
                //this.player.render();

                // Render all projectiles
                //for (Entity projectile : this.projectiles) {
                //  projectile.render();
                //}

                // Render all entities
                //for (Entity entity : entities) {
                //    entity.render();
                //}

                // Text indicator render
                //this.getTextIndicator().render();

                // Spawner
                //for (Spawner spawner : spawners) {
                //    spawner.update();
                //}

                this.hud.render();

                // Music pause
                //if (this.getGameState() == PAUSING && BGM_SOUND.isPlaying()) {
                //    BGM_SOUND.pause();
                //}

                //if (this.getGameState() == PLAYING && !BGM_SOUND.isPlaying()) {
                //    BGM_SOUND.play();
                //}
                // Esc to pause
                Gdx.input.setInputProcessor(new InputProcessor() {
                    @Override
                    public boolean keyDown(int keycode) {
                        // Pause the game if the game is starting
                        if (keycode == Input.Keys.ESCAPE) {
                            if (getGameState() != GameState.STARTING
                                    || getGameState() != GameState.ENDING) {
                                setGameState((getGameState() == PAUSING
                                        ? PLAYING
                                        : PAUSING)
                                );
                            }
                            return true;
                        }

                        // Debug shortcut
                        //if (keycode == Input.Keys.F3) {
                            //getTextIndicator().createText(new Location(getPlayer().getLocation()).add(-64, 64),
                                    //new Vector2D(0, 3F),
                                    //String.format("Debug is %s", (!isDebug() ? "on" : "off")),
                                    //1200,
                                    //.3F, (!isDebug() ? Color.GREEN : Color.RED));

                            //setDebug(!isDebug());
                            //return true;
                        //}
                        return false;
                    }

                    @Override
                    public boolean keyUp(int keycode) {
                    return false;
                }

                    @Override
                    public boolean keyTyped(char character) {
                    return false;
                }

                    @Override
                    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                        // The game is end, click to restart
                        if (getGameState() == GameState.ENDING
                                && button == Input.Buttons.LEFT) {
//                            System.out.println("Hiii");
                            //restart();
                            return true;
                        }
                        return false;
                    }

                    @Override
                    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                    return false;
                }

                    @Override
                    public boolean touchDragged(int screenX, int screenY, int pointer) {
                    return false;
                }

                    @Override
                    public boolean mouseMoved(int screenX, int screenY) {
                    return false;
                }

                    @Override
                    public boolean scrolled(float amountX, float amountY) {
                    return false;
                }
                });

                break;
            }

            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override
    public void dispose () {
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
    public TextIndicator getTextIndicator() {
        return textIndicator;
    }
}



