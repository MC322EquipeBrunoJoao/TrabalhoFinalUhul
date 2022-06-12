package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SunFlower extends Plant {

	public SunFlower(float health, float x, float y, int width, int height, int i, int j) {
		super(health, new Texture(Gdx.files.internal("sunflower.png")), x, y, i, j);
	}
 	
	public void generateEnergy() {
		
	}
}
