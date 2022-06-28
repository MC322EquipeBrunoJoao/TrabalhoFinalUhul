package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public abstract class Plant extends Character{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Sound plantSound = Gdx.audio.newSound(Gdx.files.internal("plantingSound.mp3"));
	private Lane lane;

	public Plant(float health, Texture texture, float x, float y, Lane lane) {
		super(health, texture, x, y, 80);
		this.lane = lane;
		plantSound.play();
	}
	
	public abstract void act();
	
	public Lane getLane() {
		return lane;
	}

}