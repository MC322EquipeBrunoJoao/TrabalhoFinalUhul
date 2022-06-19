package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Plant extends Character{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Plant(float health, Texture texture, float x, float y) {
		super(health, texture, x, y, 80);
	}
	
	public abstract void act();
	
}
