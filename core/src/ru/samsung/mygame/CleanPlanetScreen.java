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

public class CleanPlanetScreen implements Screen { //нигде не используется
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Texture textMapTexture;
    Vector2 pos;
    OrthographicCamera camera;
    private boolean drawText = false;
    Viewport viewport;

    public CleanPlanetScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {

        camera = new OrthographicCamera();
        viewport = new FitViewport(2150, 950, camera);

        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("лейка.png");
        textMapTexture = new Texture("field.png");
        pos = new Vector2(0, 0); ///////////

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(15 / 255f, 19 / 255f, 74 / 255f, 1);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            Vector3 worldPos = new Vector3(x, y, 0);
            camera.unproject(worldPos);

            float deltaX = worldPos.x - pos.x;
            float deltaY = worldPos.y - pos.y;

            Vector2 deltaPos = new Vector2(deltaX, deltaY).nor().scl(6f);
            if (deltaPos.x + pos.x > -300 && deltaPos.x + pos.x < 1500)// ограничение границ поля
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > -300 && deltaPos.y + pos.y < 900)// ограничение границ поля
                pos.y += deltaPos.y;

            if (pos.x > 745 && pos.x < 835  ///проверка колпака
                    && pos.y > -60 && pos.y < 30)
                myGdxGame.setScreen(myGdxGame.FirstDayNight);
        }

        camera.position.set(1080, 520,0); //1130,555
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(textMapTexture, 220, 90, 1800, 900);
        batch.draw(img, pos.x, pos.y, 350, 440);

        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
        textMapTexture.dispose();
        img.dispose();
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