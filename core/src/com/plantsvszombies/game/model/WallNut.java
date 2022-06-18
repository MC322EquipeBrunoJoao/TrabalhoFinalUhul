package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.plantsvszombies.game.controller.ActionListener;

public class WallNut extends Plant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WallNut(float xCenter, float yCenter, int i, int j) {
		super(400, new Texture(Gdx.files.internal("wallnut.png")), xCenter, yCenter, i, j);
	}

	public void act() {
		if (this.getHealth() <= 300) {
			this.setTexture(new Texture(Gdx.files.internal("wallnut2.png")));
		}
		if (this.getHealth() <= 100) {
			this.setTexture(new Texture(Gdx.files.internal("wallnut3.png")));
		}
	};

}
