package com.plantsvszombies.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.plantsvszombies.game.screens.GameScreen;

public class PlantsVsZombies extends Game {
	public SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}


	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
