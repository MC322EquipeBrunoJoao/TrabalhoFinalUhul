package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends Rectangle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Texture texture;
	
	public Entity(Texture texture, float xCenter, float yCenter, int width, int height) {
		super(xCenter, yCenter + height/2, width, height);
		this.texture = texture;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
}