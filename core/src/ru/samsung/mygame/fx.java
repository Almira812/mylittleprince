package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;


public class fx implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    Texture walkSheet;  // что-то с анимацией
    Animation<TextureRegion> walkAnimation; // что-то с анимацией
    float stateTime; // таймер, чтобы считать сколько прошло между кадрами в анимации
    private static final int FRAME_COLS = 3, FRAME_ROWS = 7;//сколько столбцов, сколько строк в анимации
    boolean isWalking; // что-то с анимацией
    boolean isPressedOnStart;

    public fx(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        //textMapTexture = new Texture("ch2.png");
        walkSheet = new Texture(Gdx.files.internal("level 3/two/after/1iwill.21.png")); // находит картинку с анимацией
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
                isWalking = false; // при каких-то условиях включается анимация можно изменить
                myGdxGame.setScreen(myGdxGame.fx1);                   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        } else {
            isPressedOnStart = false;
        }

        batch.begin();
        if (stateTime < (FRAME_COLS * FRAME_ROWS) * 0.05f) {
            stateTime += delta;
        } else {
            stateTime = (FRAME_COLS * FRAME_ROWS) * 0.05f ;
        }
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
