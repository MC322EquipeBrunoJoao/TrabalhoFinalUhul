package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

public abstract class Character extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float health;
	private boolean isDead = false;
	
	public Character(float health, Texture texture, float xCenter, float yCenter, int width) {
		super(texture, xCenter, yCenter, width, width * texture.getHeight()/texture.getWidth());
		this.health = health;
	}
	
	public void takeDamage(float damageTaken) {
		if (this.health - damageTaken <= 0) {
			isDead = true;
		}
		else {
			this.health -= damageTaken;
		}
	}
	
	public boolean isDead() {
		return isDead;
	}
	
 }
