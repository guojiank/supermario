package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.PlayScreen;

public class MarioBros extends Game {
    public static final float V_WIDTH=400f;
    public static final float V_HEIGHT=208f;
	public static final SpriteBatch batch = new SpriteBatch();
	
	@Override
	public void create () {
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
	    super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
