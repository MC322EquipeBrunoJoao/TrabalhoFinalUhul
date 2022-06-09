package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class PeaShooter extends Plant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeaShooter(float health, float x, float y, int width, int height, int i, int j) {
		super(health, new Texture(Gdx.files.internal("shooter.png")), x, y, width, height, i, j);
	}
	
	public Pea shoot() {
		Vector2 vector = new Vector2();
		this.getCenter(vector);
		return new Pea(vector.x+50, vector.y+40);
	}
}
