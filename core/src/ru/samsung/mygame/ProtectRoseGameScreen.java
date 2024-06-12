
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ProtectRoseGameScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Texture textMapTexture;
    Vector2 pos;
    OrthographicCamera camera;
    Viewport viewport;
    private boolean drawText = true;
    Texture walkSheet;  // что-то с анимацией
    Animation<TextureRegion> walkAnimation; // что-то с анимацией
    float stateTime; // таймер, чтобы считать сколько прошло между кадрами в анимации
    private static final int FRAME_COLS = 9, FRAME_ROWS = 1;//сколько столбцов, сколько строк в анимации
    boolean isWalking; // что-то с анимацией

    public ProtectRoseGameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }


    @Override
    public void show() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(2250, 1100, camera);


        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("cupol.png");   // создаем переменную для купола для розы
        textMapTexture = new Texture("field.png");
        pos = new Vector2(0, 0);
        //camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //camera.position.set(-50, -50, 0);
        //camera.update();

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(15 / 255f, 19 / 255f, 74 / 255f, 1);

        isWalking = false; // чтобы анимации просто так не работала

        Vector2 deltaPos = new Vector2();

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            Vector3 worldPos = new Vector3(x, y, 0);
            camera.unproject(worldPos);

            float deltaX = worldPos.x - pos.x;
            float deltaY = worldPos.y - pos.y;

            deltaPos = new Vector2(deltaX, deltaY).nor().scl(4f); // скорость хождения принца
            if (deltaPos.x + pos.x > -200 && deltaPos.x + pos.x < 2180)
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > -250 && deltaPos.y + pos.y < 400)
                pos.y += deltaPos.y;

            isWalking = true; // при каких-то условиях включается анимация

            if (pos.x > 710 && pos.x < 810  ///проверка колпака. Если колпак покрывает розу, то
                    && pos.y > -50 && pos.y < 50)
                myGdxGame.setScreen(myGdxGame.ThirdDayNight);

        }

        //camera.position.set(pos, 0);
        //camera.update();
        //batch.setProjectionMatrix(camera.combined);

        camera.position.set(1080, 520,0); //1130,555
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(textMapTexture, 50, 80, 2050, 890); //2150,950
        batch.draw(img, pos.x, pos.y, 700, 800);

//        if (!drawText) {
//            batch.draw(currentFrame, pos.x, pos.y, 150, 150);
//        } else {
//            font.draw(batch, "Hello World!", 500, 500); // текст появляется по середине
//        }


        batch.end();

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

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
