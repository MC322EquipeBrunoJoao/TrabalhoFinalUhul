package com.plantsvszombies.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.plantsvszombies.game.PlantsVsZombies;

public class GameOverScreen extends ScreenAdapter implements InputProcessor{

	private PlantsVsZombies game;
	private Texture backgroundImage = new Texture(Gdx.files.internal("gameOverScreenBackground.png"));
	private Sound gameOverSound = Gdx.audio.newSound(Gdx.files.internal("gameOverSound.mp3"));
	
	public GameOverScreen(PlantsVsZombies game) {
		this.game = game;
	}
	
	@Override
    public void show() {
        Gdx.input.setInputProcessor(this);
		gameOverSound.play();
	}
    
    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, 1250, 700);
        game.batch.end();
    }
    
    @Override
    public void hide() {
		gameOverSound.stop();
        super.dispose();
    }
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		game.setScreen(new StartScreen(game));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

}
