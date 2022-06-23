package com.plantsvszombies.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.plantsvszombies.game.PlantsVsZombies;

public class StartScreen extends ScreenAdapter implements InputProcessor {
	
	private Music backgroundMusic;
	
	private PlantsVsZombies game;
	//private Texture backgroundImage;
	private Texture backgroundImage = new Texture(Gdx.files.internal("startScreenBackground.png"));
	
	public StartScreen(PlantsVsZombies game) {
		this.game = game;
	}
	
	@Override
    public void show() {
		
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("startScreenSoundtrack.mp3"));
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
		backgroundMusic.setVolume(0.5f);
        Gdx.input.setInputProcessor(this);
		
	}
    
    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, 1250, 700);
        game.batch.end();
    }
    
    @Override
    public void hide() {
		backgroundMusic.stop();
        super.dispose();
    }
	

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		game.setScreen(new GameScreen(game));
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
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

