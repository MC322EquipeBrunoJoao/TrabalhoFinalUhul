package com.plantsvszombies.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.plantsvszombies.game.PlantsVsZombies;

public class StartScreen extends ScreenAdapter implements InputProcessor {
	
	private OrthographicCamera camera;
	
	private PlantsVsZombies game;
	
	public StartScreen(PlantsVsZombies game) {
		this.game = game;
	}
	
	@Override
    public void show() {
		
        camera = new OrthographicCamera(1000, 1000);
        Gdx.input.setInputProcessor(this);
		
	}
    
    @Override
    public void render(float delta) {
    	
        Gdx.gl.glClearColor(0, 0, .25f, 1);
    	
    }
    
    @Override
    public void hide() {
        super.dispose();
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
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
