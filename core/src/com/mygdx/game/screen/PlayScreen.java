package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MarioBros;
import com.mygdx.game.scenes.Hub;


public class PlayScreen implements Screen {
    private MarioBros game;
    OrthographicCamera gamecam;
    Viewport gamePort;
    Hub hub;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;

    public PlayScreen(MarioBros game) {
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, gamecam);
        hub = new Hub(game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("world.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(MarioBros.V_WIDTH/2,MarioBros.V_HEIGHT/2,0);
    }

    public void update(float dt) {
        handleInput(dt);
        gamecam.update();
        mapRenderer.setView(gamecam);
    }

    private void handleInput(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            gamecam.position.x += 100 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            gamecam.position.x -= 100 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            gamecam.position.y += 100 * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            gamecam.position.y -= 100 * dt;
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mapRenderer.render();
        game.batch.setProjectionMatrix(hub.stage.getCamera().combined);
        hub.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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

    @Override
    public void dispose() {

    }
}
