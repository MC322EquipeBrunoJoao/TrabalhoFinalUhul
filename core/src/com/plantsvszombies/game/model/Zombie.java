package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Zombie extends Character implements DynamicEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float[] velocity = {-100, 0};

	public Zombie(float health, Texture texture, float x, float y, int width, int height) {
		super(health, texture, x, y, width, height);
	}

	public static Zombie randomSpawn() {
		Texture zombieImage = new Texture(Gdx.files.internal("zombie.png"));
		Zombie newZombie = new Zombie(100, zombieImage, 800, MathUtils.random(64, 480), 70, 70);
	    return newZombie;
	}
	
	public float[] getVelocity() {
		return velocity;
	}
	
	public void move(double time) {
		x += velocity[0] * time;
		y += velocity[1] * time;
	}
 }
