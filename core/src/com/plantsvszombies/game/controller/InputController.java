package com.plantsvszombies.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.plantsvszombies.game.model.PeaShooter;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.SunFlower;
import com.plantsvszombies.game.model.Tile;

public class InputController {
	private boolean isPlantSelected = false;
	private String selectedPlantType = null;

	public InputController() {
		// TODO Auto-generated constructor stub
	}

	public Plant HandleEvent(Tile tile) {
		
		System.out.println(tile.getPositionTileX());
		System.out.println(tile.getPositionTileY());
		System.out.println(tile.isShop());
		
		if(!isPlantSelected && !tile.isShop()) {
			return null;
		}
		
		//se o tile eh um tile de loja, seleciona nova planta pra criacao
		
		if(!isPlantSelected) {
			isPlantSelected = true;
			selectedPlantType = tile.getPlantType();
			return null;
			
		}
		
		if(tile.isOutOfBounds() || tile.isShop()) {
			return null;
		}
		
		
		switch(selectedPlantType) {
		
		case "PeaShooter": 
			isPlantSelected = false;
			selectedPlantType = null;
			
			return new PeaShooter(

				tile.getX(),
				tile.getY(),
				tile.getPositionTileX(),
				tile.getPositionTileY()
				
				);
			
			
		case "Sunflower":
			isPlantSelected = false;
			selectedPlantType = null;
			
			return new SunFlower(
					
					
					tile.getX(),
					tile.getY(),
					tile.getPositionTileX(),
					tile.getPositionTileX()
					
					
					
						
					);
			
			
		default:
			return null;
		
		}
		
	
	}
	
	

}
