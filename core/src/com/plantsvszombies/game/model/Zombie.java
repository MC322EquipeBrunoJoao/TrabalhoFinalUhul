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

	public Zombie(float health, float damage, Texture texture, float x, float y, int width, int height) {
		super(health, texture, x, y, width, height);
		this.takeDamage(damage);
	}

	public static Zombie randomSpawn() {
		Texture zombieImage = new Texture(Gdx.files.internal("zombie.png"));
		Zombie newZombie = new Zombie(100, 400, zombieImage, 800, MathUtils.random(64, 480), 70, 70);
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
