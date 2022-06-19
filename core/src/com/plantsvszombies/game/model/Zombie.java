package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class Zombie extends Character {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float[] standartVelocity = {-100, 0};
	private float[] velocity = {-100,0};
	private float damage;
	private long timeLastAttack = TimeUtils.millis();

	public Zombie(float health, float damage, Texture texture, float xCenter, float yCenter) {
		super(health, texture, xCenter, yCenter, 150);
		this.damage = damage;
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
		velocity[0] = 0;
		velocity[1] = 0;
	}
	
	public void resumeMovement() {
		velocity[0] = standartVelocity[0];
		velocity[1] = standartVelocity[1];
	}
	
	public float getX() {
		return x - 30;
	}
	
	public Rectangle getHitBox() {
		return new Rectangle(x, y, width, height - 35);
	}
 }
