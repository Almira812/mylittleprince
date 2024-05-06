package ru.samsung.mygame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class DrinkRoseGameScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Texture textMapTexture;
    Vector2 pos;
    OrthographicCamera camera;
    private boolean drawText = false;

    public DrinkRoseGameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("лейка.png");
        textMapTexture = new Texture("field.png");
        pos = new Vector2(0, 0); ///////////
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(225, 225, 0);
        camera.update();
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

            Vector2 deltaPos = new Vector2(deltaX, deltaY).nor().scl(4f);
            if (deltaPos.x + pos.x > -100 && deltaPos.x + pos.x < 400)// ограничение границ поля
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > -100 && deltaPos.y + pos.y < 300)// ограничение границ поля
                pos.y += deltaPos.y;

            if (pos.x > 100 && pos.x < 120
                    && pos.y > -75 && pos.y < -65)
                myGdxGame.setScreen(myGdxGame.mainMenuScreen);
        }

        batch.begin();
        if (!drawText) {
            batch.draw(textMapTexture, 20, 80, 600, 300);
            batch.draw(img, pos.x, pos.y, 50, 80); ///размеры лейки
        } else {
            font.draw(batch, "укрой розу от ветра, накрыв ее куполом", 100, 100);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        font.dispose();
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
