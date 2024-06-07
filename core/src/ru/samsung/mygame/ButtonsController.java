package ru.samsung.mygame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class ButtonsController extends Group {

    public ButtonsController(Sprince sprince) {
        ImageButton button2 = new ImageButton(new SpriteDrawable(new Sprite(new Texture("up.png"))));
        button2.setSize(75, 75);
        button2.setPosition(50, 50);
        button2.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (sprince.getBody().getLinearVelocity().y == 0)
                    sprince.getBody().applyForceToCenter(0, 45000, true);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        ImageButton button3 = new ImageButton(new SpriteDrawable(new Sprite(new Texture("right.png"))));
        button3.setSize(75, 75);
        button3.setPosition(90, 10);
        button3.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                sprince.setMove(0);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                sprince.setMove(1);
                return true;
            }
        });
        ImageButton button4 = new ImageButton(new SpriteDrawable(new Sprite(new Texture("left.png"))));
        button4.setSize(75, 75);
        button4.setPosition(10, 10);
        button4.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                sprince.setMove(0);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                sprince.setMove(-1);
                return true;
            }
        });
        addActor(button2);
        addActor(button3);
        addActor(button4);
    }
}
