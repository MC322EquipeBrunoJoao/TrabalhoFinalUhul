package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WallNut extends Plant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int Price = 50;

	public WallNut(float xCenter, float yCenter) {
		super(400, new Texture(Gdx.files.internal("wallnut.png")), xCenter, yCenter);
	}

	public void act() {
		if (this.getHealth() <= 300) {
			this.setTexture(new Texture(Gdx.files.internal("wallnut2.png")));
		}
		if (this.getHealth() <= 100) {
			this.setTexture(new Texture(Gdx.files.internal("wallnut3.png")));
		}
	};
	
	public static int getPrice() {
		return Price;
	}
	

}
