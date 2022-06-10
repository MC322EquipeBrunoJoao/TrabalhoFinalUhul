package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Pea extends Entity implements IDynamicEntity {
	
	private float[] velocity = {0f ,100f};
	private float damage = 34;
	
	public Pea(float x, float y) {
		super(new Texture(Gdx.files.internal("pea.png")), x, y, 35, 35);
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
