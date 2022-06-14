package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Sun extends Entity {
	
	public Sun(float x, float y) {
		super(new Texture(Gdx.files.internal("sun.png")), x, y, 50, 50);
	}
	
	
}
