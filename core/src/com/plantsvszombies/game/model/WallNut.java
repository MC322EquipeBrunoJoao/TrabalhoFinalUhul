package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WallNut extends Plant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Texture wallnutTexture1 = new Texture(Gdx.files.internal("wallnut.png"));
	private static Texture wallnutTexture2 = new Texture(Gdx.files.internal("wallnut2.png"));
	private static Texture wallnutTexture3 = new Texture(Gdx.files.internal("wallnut3.png"));
	private static int Price = 50;

	public WallNut(float xCenter, float yCenter) {
		super(400, wallnutTexture1, xCenter, yCenter);
	}

	public void act() {
		if (this.getHealth() <= 300) {
			this.setTexture(wallnutTexture2);
		}
		if (this.getHealth() <= 100) {
			this.setTexture(wallnutTexture3);
		}
	};
	
	public static int getPrice() {
		return Price;
	}
	

}
