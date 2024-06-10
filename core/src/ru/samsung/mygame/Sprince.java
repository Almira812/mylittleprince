package ru.samsung.mygame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sprince extends Actor {
    Fixture fixture;
    private int movement;

    public Sprince(World world) {
        fixture = CreateFixture.createBox(world, new Vector2(90, 200), new Vector2(16, 32), false, "", (short) 0);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(new Texture("Sprince.png"),
                fixture.getBody().getPosition().x - 32,
                fixture.getBody().getPosition().y - 32,
                64,
                64);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        getBody().setLinearVelocity(
                movement * 20, //15 //скорость?
                getBody().getLinearVelocity().y
        );
    }

    public Body getBody() {
        return fixture.getBody();
    }

    public void setMove(int i) {
        movement = i;
    }
}
