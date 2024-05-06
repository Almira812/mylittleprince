package ru.samsung.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
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
    private boolean drawText = false;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("cupol.png");
        textMapTexture = new Texture("close.png");
        pos = new Vector2(0, 0); ///////////
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(225, 225, 0);
        camera.update();


    }

    @Override
    public void render() {
        ScreenUtils.clear(15/255f, 19/255f, 74/255f, 1);

        if (Gdx.input.isTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            Vector3 worldPos = new Vector3(x, y, 0);
            camera.unproject(worldPos);

            float deltaX = worldPos.x - pos.x;
            float deltaY = worldPos.y - pos.y;

            Vector2 deltaPos = new Vector2(deltaX, deltaY).nor().scl(4f);
            if (deltaPos.x + pos.x > -100 && deltaPos.x + pos.x < 270)// ограничение границ поля
                pos.x += deltaPos.x;
            if (deltaPos.y + pos.y > -100 && deltaPos.y + pos.y < 300)// ограничение границ поля
                pos.y += deltaPos.y;


        }

        camera.position.set(pos, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        if (!drawText) {
            batch.draw(textMapTexture, 0,0, 505, 550);
            batch.draw(img, pos.x, pos.y, 450, 450);
        } else {
            font.draw(batch, "укрой розу от ветра, накрыв ее куполом", 1000, 1000);
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        font.dispose();
    }
}
