package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.samsung.mygame.in2;

public class MainMenuScreen implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    Music music;
    OrthographicCamera camera;
    Viewport viewport;
    Stage stage;
    Box2DDebugRenderer b2ddr;
    OrthogonalTiledMapRenderer tmr;



    public MainMenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(2150, 950, camera);

//        stage = new Stage(viewport);


        batch = new SpriteBatch();
        font = new BitmapFont();
        textMapTexture = new Texture("menu.png");

//        tmr.setView(camera.camera);
//        camera.update(new Vector2(-100, -600));
        myGdxGame.playMenuMusic();


    }

    @Override
    public void render(float delta) {
//        stage.act();

        //music.play(); // запускает музыку
//        music.setLooping(true); //повторяет
        ScreenUtils.clear(32 / 255f, 26 / 255f, 150 / 255f, 1);
        if ((float) Gdx.input.getX() / Gdx.graphics.getWidth() > 790.000 / 2050.000 && (float)Gdx.input.getX() / Gdx.graphics.getWidth() < 1430.000 / 2050.000  /// первая кнопка лейка
                && (float)Gdx.input.getY() / Gdx.graphics.getHeight() > 350.000 / 890.000 && (float)Gdx.input.getY() / Gdx.graphics.getHeight() < 850.000 / 890.000){
            myGdxGame.setScreen(myGdxGame.introduction); //introduction

        }

        camera.position.set(1080, 520,0); //1130,555
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(textMapTexture, 50, 80, 2050, 890); //2150,950
        batch.end();

//        stage.draw();
//        tmr.render();

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
//        stage.getViewport().update(width, height, true);
        viewport.update(width, height);
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

}