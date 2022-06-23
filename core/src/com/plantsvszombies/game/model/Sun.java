package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Sun extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sun(float xCenter, float yCenter) {
		super(new Texture(Gdx.files.internal("sun.png")), xCenter, yCenter, 75, 75);
	}
	
	public boolean isInsideSunArea(int x, int y) {
		
		if(this.contains(x, y)) {
			return true;
		}
		
		return false;
		
		
	}
		
}