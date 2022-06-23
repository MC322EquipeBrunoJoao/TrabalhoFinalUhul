package com.plantsvszombies.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class ShopController {
	
	private static final ShopController shopController = new ShopController();
	private int sunAmount;
	private Sound pickSunSound = Gdx.audio.newSound(Gdx.files.internal("sunCollected.mp3"));
	
	public ShopController() {
		// TODO Auto-generated constructor stub
	}
	
	public static ShopController getInstance() {
		return shopController;
	}
	
	public int getSunAmount() {
		return sunAmount;
	}
	
	public void pickSun() {
		pickSunSound.play();
		sunAmount += 50;
		
	}

}
