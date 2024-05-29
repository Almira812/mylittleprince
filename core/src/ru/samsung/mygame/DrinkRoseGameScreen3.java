package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.samsung.mygame.in2;

import java.util.Timer;


public class DrinkRoseGameScreen3 implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    Texture walkSheet;  // что-то с анимацией
    Animation<TextureRegion> walkAnimation; // что-то с анимацией
    float stateTime; // таймер, чтобы считать сколько прошло между кадрами в анимации
    private static final int FRAME_COLS = 21, FRAME_ROWS = 1;//сколько столбцов, сколько строк в анимации
    boolean isWalking; // что-то с анимацией
    int s = 0;
    boolean isPressedOnStart;


    public DrinkRoseGameScreen3(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        //textMapTexture = new Texture("ch2.png");
        walkSheet = new Texture(Gdx.files.internal("21DrinkRoseGameScreen3.png")); // находит картинку с анимацией
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / FRAME_COLS,
                walkSheet.getHeight() / FRAME_ROWS); // разрезает картинку с анимацией чтобы они были в одну строчку
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS]; // соединяет части картинки с анимацией в одну строчку
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation<TextureRegion>(0.05f, walkFrames); // время между переходами в анимации
        isPressedOnStart = Gdx.input.isTouched();
    }

    @Override
    public void render(float delta) {
        isWalking = true; // чтобы анимации просто так не работала
        ScreenUtils.clear(32 / 255f, 26 / 255f, 150 / 255f, 1);
        if (Gdx.input.isTouched()) {
            if (!isPressedOnStart) {
                int x = Gdx.input.getX();
                int y = Gdx.input.getY();
                isWalking = false; // при каких-то условиях включается анимация можно изменить

                myGdxGame.setScreen(myGdxGame.drinkRoseGameScreen4);
            }
        } else {
            isPressedOnStart = false;
        }

        if (stateTime < (FRAME_COLS * FRAME_ROWS) * 0.05f) {
            stateTime += delta;
        } else {
            stateTime = (FRAME_COLS * FRAME_ROWS) * 0.05f ;
        }
        batch.begin();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime - 0.01f, true); // что-то с анимацией
        batch.draw(currentFrame,50,  80, 2150, 950); // если персонаж двигается, то включается анимация
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