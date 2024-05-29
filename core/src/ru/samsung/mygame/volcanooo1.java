package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.mygame.in2;

public class volcanooo1 implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    boolean isPressedOnStart;//доп

    public volcanooo1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        textMapTexture = new Texture("volcanooo1.png");
        isPressedOnStart = Gdx.input.isTouched();//доп
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(32 / 255f, 26 / 255f, 150 / 255f, 1);
        if (Gdx.input.getX() > 890 && Gdx.input.getX() < 1200  /// первая кнопка лейка
                && Gdx.input.getY() > 400 && Gdx.input.getY() < 600){
            myGdxGame.setScreen(myGdxGame.volcanooo2);
        }
        batch.begin();
        batch.draw(textMapTexture, 50, 80, 2150, 950);
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