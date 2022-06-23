package com.plantsvszombies.game.controller;

public class ShopController {
	
	private static final ShopController shopController = new ShopController();
	private int sunAmount;
	
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
		
		sunAmount += 50;
		
	}

}
