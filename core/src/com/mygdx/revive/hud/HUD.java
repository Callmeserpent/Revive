package com.mygdx.revive.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.revive.Renderable;
import com.mygdx.revive.World;



import java.util.ArrayList;
import java.util.List;

public class HUD implements Renderable{
    public static final Texture HEALTH_FULL_TEXTURE = new Texture(Gdx.files.internal("health.png"));
    public static final Texture HEALTH_HALF_TEXTURE = new Texture(Gdx.files.internal("halfhealth.png"));
    public static final Texture NO_HEALTH_TEXTURE = new Texture(Gdx.files.internal("nohealth.png"));

    private final World world;
    public List<Sprite> bulletSprites = new ArrayList<>();
    public List<Sprite> healthSprites = new ArrayList<>();

    private Stage stage;
    private Table table;

    public HUD(World world) {
        this.world = world;
    }

    @Override
    public void create(){}

    @Override
    public void render(){}

    @Override
    public void dispose(){}
}