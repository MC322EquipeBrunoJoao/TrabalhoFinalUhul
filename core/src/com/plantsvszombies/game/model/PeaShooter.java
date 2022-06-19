package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.controller.ActionListener;

public class PeaShooter extends Plant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long lastShootTime = TimeUtils.millis();

	public PeaShooter(float xCenter, float yCenter) {
		super(100, new Texture(Gdx.files.internal("shooter.png")), xCenter, yCenter);
	}

	public void act() {
		if (TimeUtils.timeSinceMillis(lastShootTime) > 2000) {
			ActionListener.getInstance().notifyNewPlantProjectile(shoot());
			lastShootTime = TimeUtils.millis();
		}
	}
	
	public Projectile shoot() {
		Vector2 vector = new Vector2();
		this.getCenter(vector);
		return new Projectile(new Texture(Gdx.files.internal("pea.png")), vector.x + 35, vector.y + 15, 25, 25);
	}
}
