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
import ru.samsung.mygame.in2;

public class ProtectRoseGameScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    BitmapFont font;
    Texture img;
    Texture textMapTexture;
    Vector2 pos;
    OrthographicCamera camera;  // импортируем шнягу

    public ProtectRoseGameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();   // запускаем эти методы для отрисовки
        img = new Texture("cupol.png");   // создаем переменную для купола для розы
        textMapTexture = new Texture("field.png");  // создаем переменную для фона
        pos = new Vector2(820, 440); //начальные координаты купола
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(225, 225, 0);  // зафиксированная позиция камеры
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
            if (deltaPos.x + pos.x > -300 && deltaPos.x + pos.x < 1500)// ограничение границ поля
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > -300 && deltaPos.y + pos.y < 900)// ограничение границ поля
                pos.y += deltaPos.y;

            if (pos.x > 710 && pos.x < 810  ///проверка колпака. Если колпак покрывает розу, то
                    && pos.y > -50 && pos.y < 50)
                myGdxGame.setScreen(myGdxGame.ThirdDayNight); // он переводит игрока на следующий экран

        }
        batch.begin();
        batch.draw(textMapTexture, 220, 90, 1800, 900); // отрисовываем фон. Тут соответственно
        //начальные координаты и размеры
        batch.draw(img, pos.x, pos.y, 700, 800); //отрисовываем купол

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
