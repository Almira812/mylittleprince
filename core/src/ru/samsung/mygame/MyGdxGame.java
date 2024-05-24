package ru.samsung.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Texture textMapTexture;
    Vector2 pos;
    OrthographicCamera camera;
    private boolean drawText = true;
    Texture walkSheet;  // что-то с анимацией
    Animation<TextureRegion> walkAnimation; // что-то с анимацией
    float stateTime; // таймер, чтобы считать сколько прошло между кадрами в анимации
    private static final int FRAME_COLS = 9, FRAME_ROWS = 1;//сколько столбцов, сколько строк в анимации
    boolean isWalking; // что-то с анимацией

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("dvig prince all1.png");
        textMapTexture = new Texture("planet1.png");
        pos = new Vector2(0, 0);
        //camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //camera.position.set(-50, -50, 0);
        //camera.update();


        walkSheet = new Texture(Gdx.files.internal("dvig prince atlas.png")); // находит картинку с анимацией
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

    }

    @Override
    public void render() {
        ScreenUtils.clear(15 / 255f, 19 / 255f, 74 / 255f, 1);

        isWalking = false; // чтобы анимации просто так не работала

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.graphics.getHeight() - Gdx.input.getY();

            Vector3 worldPos = new Vector3(x, y, 0);
            //camera.unproject(worldPos);

            float deltaX = worldPos.x - pos.x;
            float deltaY = worldPos.y - pos.y;

            Vector2 deltaPos = new Vector2(deltaX, deltaY).nor().scl(8f); // скорость хождения принца
            if (deltaPos.x + pos.x > -200 && deltaPos.x + pos.x < 2180)
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > -250 && deltaPos.y + pos.y < 400)
                pos.y += deltaPos.y;

            isWalking = true; // при каких-то условиях включается анимация
        }

        //camera.position.set(pos, 0);
        //camera.update();
        //batch.setProjectionMatrix(camera.combined);

        batch.begin();
        stateTime += Gdx.graphics.getDeltaTime(); // что с анимацией
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true); // что-то с анимацией

        batch.draw(textMapTexture, 0, 0, 2250, 1100); //2150,950

        if (isWalking)
            batch.draw(currentFrame, pos.x, pos.y, 512, 512); // если персонаж двигается, то включается анимация /750,840 / 100,117
        else
            batch.draw(img, pos.x, pos.y, 512, 512);
//        if (!drawText) {
//            batch.draw(currentFrame, pos.x, pos.y, 150, 150);
//        } else {
//            font.draw(batch, "Hello World!", 500, 500); // текст появляется по середине
//        }


        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
