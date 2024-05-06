package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenuScreen implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;


    public MainMenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);
        if (Gdx.input.isTouched()) {
            myGdxGame.setScreen(myGdxGame.protectRoseGameScreen);
        }
        batch.begin();
        font.draw(batch, "Welcome to LP!", 100, 150);
        font.draw(batch, "Tap to continue!", 100, 100);
        batch.end();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {

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
