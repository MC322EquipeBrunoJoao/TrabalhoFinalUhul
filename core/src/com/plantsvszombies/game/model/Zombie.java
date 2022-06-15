package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Zombie extends Character {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float[] previousVelocity = new float[2];
	private float[] velocity = {-100, 0};
	private float damage;
	private long timeLastAttack = TimeUtils.millis();

	public Zombie(float health, float damage, Texture texture, float xCenter, float yCenter) {
		super(health, texture, xCenter, yCenter, 100);
		this.damage = damage;
	}

	public static Zombie randomSpawn() {
		Texture zombieImage = new Texture(Gdx.files.internal("zombie.png"));
		Zombie newZombie = new Zombie(100, 35, zombieImage, 1350, MathUtils.random(0, 500));
	    return newZombie;
	}
	
	public float[] getVelocity() {
		return velocity;
	}
	
	public float getDamage() {
		return damage;
	}
	
	public float attack() {
		if (TimeUtils.timeSinceMillis(timeLastAttack) > 3000) {
			timeLastAttack = TimeUtils.millis();
			return damage;
		}
		else return 0;
	}
	
	public boolean isMoving() {
		if (velocity[0] != 0 || velocity[1] != 0) {
			return true;
		}
		return false;
	}
	
	public void move(double time) {
		x += velocity[0] * time;
		y += velocity[1] * time;
	}
	
	public void stop() {
		previousVelocity[0] = velocity[0];
		previousVelocity[1] = velocity[1];
		velocity[0] = 0;
		velocity[1] = 0;
	}
	
	public void resumeMovement() {
		velocity[0] = previousVelocity[0];
		velocity[1] = previousVelocity[1];
	}
	
	public float getX() {
		return x - 30;
	}
 }
