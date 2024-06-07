package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class asteroud330 implements Screen {
    Camera camera;
    StretchViewport viewport;
    Stage stage;

    World world;
    TiledMap map;
    OrthogonalTiledMapRenderer tmr;
    Box2DDebugRenderer b2ddr;
    Array<Fixture> mapBody;
    Sprince sprince;
    MyGdxGame myGdxGame;

    public asteroud330(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        camera = new Camera(new Vector2(0, 0));
        viewport = new StretchViewport(640, 360, camera.camera);
        stage = new Stage(viewport);

        world = new World(new Vector2(0, -10), true);
        b2ddr = new Box2DDebugRenderer();

        mapBody = new Array<>();
        map = new TmxMapLoader().load("asteroud330.tmx");
        tmr = new OrthogonalTiledMapRenderer(map, 2.5f); //размер карты
        mapBody = TiledObjectUtil.buildBuildingsBodies(map, world, 2.5f);

        sprince = new Sprince(world);
        ButtonsController buttonsController = new ButtonsController(sprince);

        stage.addActor(sprince);
        stage.addActor(buttonsController);

        Gdx.input.setInputProcessor(stage);

        tmr.setView(camera.camera);
        camera.update(new Vector2(-100, -600));
    }

    @Override
    public void render(float delta) {
        world.step(delta, 6, 2);
        stage.act();

        if (sprince.getBody().getPosition().y < 0) { // если персонаж упал
            myGdxGame.setScreen(myGdxGame.asteroud330);
        }
        if (sprince.getBody().getPosition().x > 600) { // если прошел
            myGdxGame.setScreen(myGdxGame.geograf);
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tmr.render();
        stage.draw();
        b2ddr.render(world, stage.getCamera().combined);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}