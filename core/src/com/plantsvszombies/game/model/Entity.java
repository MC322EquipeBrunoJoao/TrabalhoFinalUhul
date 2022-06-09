package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity extends Rectangle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Texture texture;
	
	public Entity(Texture texture, float x, float y, int width, int height) {
		super.setCenter(x, y);
		super.width = width;
		super.height = height;
		this.texture = texture;
	}
	
	public Texture getTexture() {
		return texture;
	}
}