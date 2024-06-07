package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class CreateFixture {
    public static Fixture createBox(World world, Vector2 pos, Vector2 size,
                                    boolean isStatic, String userData, short groupIndex) {
        Filter f = new Filter();
        f.groupIndex = groupIndex;

        Body pBody;
        Fixture fixture;
        BodyDef def = new BodyDef();

        if (isStatic) def.type = BodyDef.BodyType.StaticBody;
        else def.type = BodyDef.BodyType.DynamicBody;

        def.position.set(pos.x + 5, pos.y + 5);
        def.fixedRotation = true;
        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);

        fixture = pBody.createFixture(shape, 0.01f);
        fixture.setUserData(userData);
        fixture.setFilterData(f);
        shape.dispose();
        Gdx.app.log("Create Fixture", "Fixture for " + userData + " created");

        return fixture;
    }

    public static Fixture createCircle(World world, Vector2 pos, float radius,
                                       boolean isStatic, String userData, short groupIndex) {
        Filter f = new Filter();
        f.groupIndex = groupIndex;

        Body pBody;
        Fixture fixture;
        BodyDef def = new BodyDef();

        if (isStatic) def.type = BodyDef.BodyType.StaticBody;
        else def.type = BodyDef.BodyType.DynamicBody;

        def.position.set(pos.x, pos.y);
        def.fixedRotation = false;
        pBody = world.createBody(def);

        CircleShape shape = new CircleShape();
        shape.setPosition(new Vector2(0, 0));
        shape.setRadius(radius);

        fixture = pBody.createFixture(shape, 1);
        fixture.setUserData(userData);
//        fixture.setUserData(new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")))); //You can do that but better don't do it
        fixture.setFilterData(f);
        shape.dispose();

        return fixture;
    }
}