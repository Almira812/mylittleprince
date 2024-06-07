package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.mygame.in2;

public class MainMenuScreen implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    Music music;


    public MainMenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music/7. November Sun (ft. Claudia Lessing) (MASTER).mp3"));
        batch = new SpriteBatch();
        font = new BitmapFont();
        textMapTexture = new Texture("menu.png");
    }

    @Override
    public void render(float delta) {
        music.play(); // запускает музыку
        ScreenUtils.clear(32 / 255f, 26 / 255f, 150 / 255f, 1);
        if (Gdx.input.getX() > 890 && Gdx.input.getX() < 1330  /// первая кнопка лейка
                && Gdx.input.getY() > 600 && Gdx.input.getY() < 700){
            myGdxGame.setScreen(myGdxGame.introduction); //introduction

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