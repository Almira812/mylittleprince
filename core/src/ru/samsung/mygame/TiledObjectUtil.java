package ru.samsung.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class TiledObjectUtil {
    private static float d;

    public static Array<Fixture> buildBuildingsBodies(TiledMap tiledMap, World world, float density) {
        d = density;
        MapObjects objects = tiledMap.getLayers().get("abc").getObjects();
        Array<Fixture> fixtures = new Array<>();
        for (MapObject object : objects) {
            Shape shape;

            try {
                shape = createRectangle((RectangleMapObject) object);
                Fixture fixture;
                Body body;
                BodyDef bdef = new BodyDef();
                bdef.type = BodyDef.BodyType.StaticBody;
                body = world.createBody(bdef);
                fixture = body.createFixture(shape, 1);
                shape.dispose();
                fixture.setUserData("world");
                Gdx.app.log("Tiled Object Util", "Created rectangle");
                //polyline.getPolyline().getTransformedVertices()
                Vector2 center = new Vector2();
                ((RectangleMapObject) object).getRectangle().getCenter(center);
                fixture.getBody().setTransform(center.scl(d), 0);
                fixtures.add(fixture);
                continue;
            } catch (Exception e) {
            }

            try {
                shape = createPolyline((PolylineMapObject) object);
                Fixture fixture;
                Body body;
                BodyDef bdef = new BodyDef();
                bdef.type = BodyDef.BodyType.StaticBody;
                body = world.createBody(bdef);
                fixture = body.createFixture(shape, 1);
                shape.dispose();
                fixture.setUserData("world");
                Gdx.app.log("Tiled Object Util", "Created Polyline");
                fixture.getBody().setTransform(0, 0, 0);
                fixtures.add(fixture);
                continue;
            } catch (Exception e) {
            }
        }
        return fixtures;
    }

    public static Shape createRectangle(RectangleMapObject rectangle) {
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(rectangle.getRectangle().width * d / 2, rectangle.getRectangle().height * d / 2);
        return polygonShape;
    }

    private static ChainShape createPolyline(PolylineMapObject polyline) {
        float[] vertices = polyline.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < worldVertices.length; i++) {
            worldVertices[i] = new Vector2(vertices[i * 2] * d, vertices[i * 2 + 1] * d);
//            Gdx.app.log("Координаты " + (i + 1) + " вершины коллизии", "X: " + vertices[i * 2] +
//                    "; Y: " + vertices[i * 2 + 1]);
        }
        ChainShape cs = new ChainShape();
        cs.createChain(worldVertices);
        return cs;
    }
}
