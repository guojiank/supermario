package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.game.MarioBros;
import com.mygdx.game.scenes.Hub;


public class PlayScreen implements Screen {
    private MarioBros game;
//    OrthographicCamera gamecam;
//    Viewport gamePort;
    Hub hub;

    public PlayScreen(MarioBros game) {
        this.game = game;
//        gamecam = new OrthographicCamera();
//        gamePort = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_HEIGHT,gamecam);
        hub = new Hub(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hub.stage.getCamera().combined);
        hub.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
//        gamePort.update(width,height);
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
