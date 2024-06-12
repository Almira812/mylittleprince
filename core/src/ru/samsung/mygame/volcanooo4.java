package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.samsung.mygame.in2;

public class volcanooo4 implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    boolean isPressedOnStart;//доп
    OrthographicCamera camera;
    Viewport viewport;

    public volcanooo4(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(2150, 950, camera);

        batch = new SpriteBatch();
        font = new BitmapFont();
        textMapTexture = new Texture("volcanooo/volcanooo4.png");
        isPressedOnStart = Gdx.input.isTouched();//доп
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(32 / 255f, 26 / 255f, 150 / 255f, 1);
        if (Gdx.input.isTouched()) {
            if (!isPressedOnStart) { // проверка условия прикосновения к экран
                myGdxGame.setScreen(myGdxGame.FirstDayNight); /// перекидывает да следующий экран
            }
        } else {
            isPressedOnStart = false;
        }
//        if (Gdx.input.getX() > 890 && Gdx.input.getX() < 1200  /// первая кнопка лейка
//                && Gdx.input.getY() > 400 && Gdx.input.getY() < 600){
//            myGdxGame.setScreen(myGdxGame.FirstDayNight);
//        }

        camera.position.set(1080, 520,0); //1130,555
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(textMapTexture, 50, 80, 2050, 890);
        batch.end();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
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