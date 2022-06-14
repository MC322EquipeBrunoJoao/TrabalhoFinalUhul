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
	
	public Entity(Texture texture, float x, float y, int width, int height) {
		super.setCenter(x - width/2, y);
		super.width = width;
		super.height = height;
		this.texture = texture;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public float getX() {
		Vector2 vector = new Vector2();
		this.getCenter(vector);
		return vector.x;
	}
	
	public float getY() {
		Vector2 vector = new Vector2();
		this.getCenter(vector);
		return vector.y;
	}
}