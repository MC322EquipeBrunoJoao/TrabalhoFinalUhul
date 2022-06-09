package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Character extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float health;
	private boolean isDead = false;
	
	public Character(float health, Texture texture, float x, float y, int width, int height) {
		super(texture, x, y, width, height);
		this.health = health;
	}
	
	public void takeDamage(float damage) {
		if (this.health - damage < 0)
			isDead = true;
		else
			this.health -= damage;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
 }
