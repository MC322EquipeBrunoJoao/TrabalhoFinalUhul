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
	private GameScreen gameScreen;
	private GameOverScreen gameOverScreen;
	private StartScreen startScreen;
	
	@Override
	public void create () {
		
		MasterController.getInstance().setGame(this);
		batch = new SpriteBatch();
		
		gameScreen = new GameScreen(this);
		gameOverScreen = new GameOverScreen(this);
		startScreen = new StartScreen(this);
		
		setScreen(gameScreen);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	
	public GameScreen getGameScreen() {
		return gameScreen;
	}
	
	public GameOverScreen getGameOverScreen() {
		return gameOverScreen;
	}

}