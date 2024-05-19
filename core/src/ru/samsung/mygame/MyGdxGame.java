package ru.samsung.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {


    public MainMenuScreen mainMenuScreen;
    public ProtectRoseGameScreen protectRoseGameScreen;
    public DrinkRoseGameScreen drinkRoseGameScreen;
    public Planetgame planetgame;
    public IntroductionScreen introduction;
    public in2 int2;
    public in3 int3;
    public in4 int4;
    public in5 int5;
    public in6 int6;
    public in7 int7;
    public in8 int8;
    public in9 int9;
    public in10 int10;

    @Override
    public void create() {
        mainMenuScreen = new MainMenuScreen(this);
        protectRoseGameScreen = new ProtectRoseGameScreen(this);
        drinkRoseGameScreen = new DrinkRoseGameScreen(this);
        introduction = new IntroductionScreen(this);
        planetgame = new Planetgame(this);
        int2 = new in2(this);
        int3 = new in3(this);
        int4 = new in4(this);
        int5 = new in5(this);
        int6 = new in6(this);
        int7 = new in7(this);
        int8 = new in8(this);
        int9 = new in9(this);
        int10 = new in10(this);
        setScreen(mainMenuScreen);
    }
}
