package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.controller.ActionListener;

public class PeaShooter extends Plant {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6402792614474539611L;
	private long lastShootTime = TimeUtils.millis();
	private static Sound shootSound = Gdx.audio.newSound(Gdx.files.internal("peashooterShoot.mp3"));
	private static Texture shootTexture = new Texture(Gdx.files.internal("pea.png"));
	private static int Price = 100;
	private Lane lane;

	public PeaShooter(float xCenter, float yCenter, Lane lane) {
		super(100, new Texture(Gdx.files.internal("shooter.png")), xCenter, yCenter, lane);
		this.lane = lane;
	}

	public void act() {
		if (TimeUtils.timeSinceMillis(lastShootTime) > 3000 && lane.isThereAZombie()) {
			ActionListener.getInstance().notifyNewPlantProjectile(shoot());
			lastShootTime = TimeUtils.millis();
		}
	}
	
	private Projectile shoot() {
		shootSound.play(1f);
		Vector2 vector = new Vector2();
		this.getCenter(vector);
		return new Projectile(shootTexture, vector.x + 35, vector.y + 15, 25, 25);
	}
	
	public static int getPrice() {
		return Price;
	}
}
