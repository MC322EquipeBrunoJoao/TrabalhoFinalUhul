package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PeaShooter extends Plant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeaShooter(float health, float x, float y, int width, int height, int i, int j) {
		super(health, new Texture(Gdx.files.internal("shooter.png")), x, y, width, height, i, j);
	}
	
	public Pea shoot() {
		return new Pea(x, y);
	}
}
