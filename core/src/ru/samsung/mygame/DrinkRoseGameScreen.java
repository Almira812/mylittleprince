package ru.samsung.mygame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.samsung.mygame.in2;

public class DrinkRoseGameScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture textMapTexture;
    Vector2 pos;
    OrthographicCamera camera;
    Viewport viewport;

    public DrinkRoseGameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        textMapTexture = new Texture("111.png");
        pos = new Vector2(820, 440); ///////////
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(2150, 950, camera);
//        camera.position.set(225, 225, 0);
//        camera.update();


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(32 / 255f, 26 / 255f, 150 / 255f, 1);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            Vector3 worldPos = new Vector3(x, y, 0);
            camera.unproject(worldPos);

            float deltaX = worldPos.x - pos.x;
            float deltaY = worldPos.y - pos.y;

            Vector2 deltaPos = new Vector2(deltaX, deltaY).nor().scl(4f);
//            if (deltaPos.x + pos.x > -300 && deltaPos.x + pos.x < 1500)// ограничение границ поля
//                pos.x += deltaPos.x;
//            if (deltaPos.y + pos.y > -300 && deltaPos.y + pos.y < 900)// ограничение границ поля
//                pos.y += deltaPos.y;

            if ((float)Gdx.input.getX() / Gdx.graphics.getWidth()> 450.000 / 2050.000 && (float)Gdx.input.getX() / Gdx.graphics.getWidth()< 800.000 / 2050.000  /// первая кнопка лейка
                    && (float)Gdx.input.getY() / Gdx.graphics.getHeight()> 50.000 / 890.000 && (float)Gdx.input.getY() / Gdx.graphics.getHeight()< 350.000 / 890.000)
                myGdxGame.setScreen(myGdxGame.drinkRoseGameScreen1);

            if ((float)Gdx.input.getX() / Gdx.graphics.getWidth()> 1450.000 / 2050.000 && (float)Gdx.input.getX() / Gdx.graphics.getWidth()< 1600.000 / 2050.000  /// вторая кнопка солнце
                    && (float)Gdx.input.getY() / Gdx.graphics.getHeight()> 150.000 / 890.000 && (float)Gdx.input.getY() / Gdx.graphics.getHeight()< 250.000 / 890.000)
                myGdxGame.setScreen(myGdxGame.drinkRoseGameScreen1);

        }

        camera.position.set(1080, 520,0); //1130,555
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(textMapTexture, 50, 80, 2050, 890);

        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
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
