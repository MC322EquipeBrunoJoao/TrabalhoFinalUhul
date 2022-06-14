package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Pea extends Entity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float[] velocity = {100f, 0f};
	private float damage = 35f;
	
	public Pea(float x, float y) {
		super(new Texture(Gdx.files.internal("pea.png")), x, y, 25, 25);
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
