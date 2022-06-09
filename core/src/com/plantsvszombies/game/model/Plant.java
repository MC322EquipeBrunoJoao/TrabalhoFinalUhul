package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Plant extends Character{
	
	private int i;
	private int j;
	
	public Plant(float health, Texture texture, float x, float y, int width, int height, int i, int j) {
		super(health, texture, x, y, width, height);
		this.i = i;
		this.j = j;
	}

}
