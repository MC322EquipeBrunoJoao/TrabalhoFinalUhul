package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Zombie extends Character implements IDynamicEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float[] velocity = {-100, 0};
	private float damage;

	public Zombie(float health, float damage, Texture texture, float x, float y) {
		super(health, texture, x, y, 100);
	}

	public static Zombie randomSpawn() {
		Texture zombieImage = new Texture(Gdx.files.internal("zombie.png"));
		Zombie newZombie = new Zombie(100, 400, zombieImage, 1350, MathUtils.random(0, 500));
	    return newZombie;
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
