package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class gamesnake implements Screen {
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
    Music music;

    public gamesnake(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        //music = Gdx.audio.newMusic(Gdx.files.internal("music/7. November Sun (ft. Claudia Lessing) (MASTER).mp3"));

        camera = new Camera(new Vector2(0, 0));
        viewport = new StretchViewport(640, 360, camera.camera);
        stage = new Stage(viewport);

        world = new World(new Vector2(0, 0), true);
        b2ddr = new Box2DDebugRenderer();

        mapBody = new Array<>();
        map = new TmxMapLoader().load("snake.tmx");
        tmr = new OrthogonalTiledMapRenderer(map, 2.5f);
        mapBody = TiledObjectUtil.buildBuildingsBodies(map, world, 2.5f);

        sprince = new Sprince(world);

        stage.addActor(sprince);

        Gdx.input.setInputProcessor(stage);

        tmr.setView(camera.camera);
        camera.update(new Vector2(-100, -600));
        if (sprince.getBody().getPosition().x < 100
                && sprince.getBody().getPosition().y > 295) {
            myGdxGame.stopMenuMusic();
        }



    }

    @Override
    public void render(float delta) {


        world.step(delta, 6, 2);
        stage.act();
        if (sprince.getBody().getPosition().x < 100
                && sprince.getBody().getPosition().y > 295) {
            myGdxGame.stopMenuMusic();
            myGdxGame.setScreen(myGdxGame.mainMenuScreen);

        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tmr.render();
        stage.draw();
        //b2ddr.render(world, stage.getCamera().combined);

        System.out.println(sprince.getBody().getPosition());
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

    public class Sprince extends Actor {
        private Texture img;
        private Fixture fixture;
        private boolean isMovingRight;

        public Sprince(World world) {
            img = new Texture("Sprince.png");
            fixture = CreateFixture.createCircle(world, new Vector2(540, 60), 16, false, "", (short) 0);
            fixture.setFriction(10f);
        }

        @Override
        public void act(float delta) {
            super.act(delta);

            if (Gdx.input.isTouched()) {
                float x = Gdx.input.getX();
                float y = Gdx.graphics.getHeight() - Gdx.input.getY();

                x = x - fixture.getBody().getPosition().x;
                y = y - fixture.getBody().getPosition().y;

                fixture.getBody().setLinearVelocity(new Vector2(x, y).nor().scl(40));

                isMovingRight = x > 0;
            }
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            super.draw(batch, parentAlpha);

            TextureRegion texture = new TextureRegion(img);
            texture.flip(!isMovingRight, false);

            batch.draw(texture,
                    fixture.getBody().getPosition().x - 32,
                    fixture.getBody().getPosition().y - 32,
                    64,
                    64);
        }

        public Body getBody() {
            return fixture.getBody();
        }
    }
}