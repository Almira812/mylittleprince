package ru.samsung.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("theprince.png");
        textMapTexture = new Texture("picture.png");
        pos = new Vector2(0, 0);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(-50, -50, 0);
        camera.update();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            Vector3 worldPos = new Vector3(x, y, 0);
            camera.unproject(worldPos);

            float deltaX = worldPos.x - pos.x;
            float deltaY = worldPos.y - pos.y;

            Vector2 deltaPos = new Vector2(deltaX, deltaY).nor().scl(10f);
            if (deltaPos.x + pos.x > 0 && deltaPos.x + pos.x < 900)
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > 0 && deltaPos.y + pos.y < 883)
                pos.y += deltaPos.y;

        }

        camera.position.set(pos, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(textMapTexture, 0, 0, 1000, 1000);
        batch.draw(img, pos.x, pos.y, 100, 117);
        if (!drawText) {
            batch.draw(img, pos.x, pos.y, 150, 150);
        } else {
            font.draw(batch, "Hello World!", 500, 500);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
