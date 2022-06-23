package com.plantsvszombies.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.plantsvszombies.game.controller.MasterController;
import com.plantsvszombies.game.screens.GameOverScreen;
import com.plantsvszombies.game.screens.GameScreen;
import com.plantsvszombies.game.screens.StartScreen;

public class PlantsVsZombies extends Game {
	
	public SpriteBatch batch;
	
	@Override
	public void create () {
		
		MasterController.getInstance().setGame(this);
		batch = new SpriteBatch();
		
		setScreen(new StartScreen(this));
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}