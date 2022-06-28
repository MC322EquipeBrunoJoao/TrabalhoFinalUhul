package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;

public class Projectile extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float[] velocity = {100f, 0f};
	private float damage = 35f;
	
	public Projectile(Texture texture, float xCenter, float yCenter, int width, int height) {
		super(texture, xCenter, yCenter, width, height);
	}
	
	public float[] getVelocity() {
		return velocity;
	}
	
	public float getDamage() {
		return damage;
	}
	
	public void move(double time) {
		x += velocity[0] * time;
		y += velocity[1] * time;
	}
	
 }
