package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class Character extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float health;
	private boolean isDead = false;
	
	public Character(float health, Texture texture, float xCenter, float yCenter, int height) throws NumberFormatException {
		super(texture, xCenter, yCenter, height * texture.getWidth()/texture.getHeight(), height);
		this.health = health;
	}
	
	public void takeDamage(float damageTaken) {
		if (health - damageTaken <= 0) {
			isDead = true;
		}
		else {
			this.health -= damageTaken;
		}
	}
	
	public boolean isDead() {
		return isDead;
	}

	public float getHealth() {
		return health;
	}
	
 }
