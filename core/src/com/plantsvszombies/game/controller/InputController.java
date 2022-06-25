package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.Lane;
import com.plantsvszombies.game.model.PeaShooter;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.ShopTile;
import com.plantsvszombies.game.model.SunFlower;
import com.plantsvszombies.game.model.Tile;
import com.plantsvszombies.game.model.WallNut;

public class InputController {
	
	private static final InputController inputController = new InputController();
	private boolean isPlantSelected = false;
	private String selectedPlantType = null;

	private InputController() {};
	
	protected static InputController getInstance() {
		return inputController;
	}
	
	private Plant selectPlant(ITile tile) {
		
		if(tile.getPositionTileY() != 5)
			return null;
		
		
		else {
			
			isPlantSelected = true;
			selectedPlantType = tile.getPlantType();
			return null;
			
		}
		
	}
	
	private Plant createPlant(ITile tile, Lane lane) {
		
		if(tile.getPositionTileY() != 5) {	
			Plant plant = MapController.getInstance()
					.createPlant(
							selectedPlantType,
							tile.getX(),
							tile.getY(),
							lane
						);		

			tile.setPlant(plant);
			tile.setPlantType(selectedPlantType);
			isPlantSelected = false;
			selectedPlantType = null;
			return plant;
			
			
			
			
		}
		
		else {
			
			selectedPlantType = tile.getPlantType();
			return null;
				
		}
		
		
		
	}

	public Plant HandleTileEvent(ITile tile) {
		
		System.out.println(tile.getPositionTileX());
		System.out.println(tile.getPositionTileY());
		System.out.println(tile instanceof ShopTile);
		
		Lane lane = tile.getLane();
	
		
		
		
		if(tile.isOutOfBounds() || tile.isThereAPlant()) 
			return null;

		
		if(!isPlantSelected) 
			return selectPlant(tile);
			
		
		else {
			
			try{		
				 return createPlant(tile, lane);	 
			}
			
			catch(NullPointerException e) {
				
				System.out.println("Planta inválida!");
				
				return null;
				
			}
			
			
		}
		
		
		
				

		/*if(tile.IsThereAPlant()) 
			return null;
			
		
		
		if(!isPlantSelected && !(tile instanceof ShopTile)) {
			return null;
		}
		
		//se o tile eh um tile de loja, seleciona nova planta pra criacao
		
		if(!isPlantSelected) {
			isPlantSelected = true;
			selectedPlantType = tile.getPlantType();
			return null;
			
		}
		
		if(tile.isOutOfBounds()) {
			return null;
		}
		
		if(tile.isShop()) {
			
			isPlantSelected = true;
			selectedPlantType = tile.getPlantType();
			return null;
			
		}
		
		switch(selectedPlantType) {
		
		case "PeaShooter": 
			isPlantSelected = false;
			selectedPlantType = null;
			tile.PlaceAPlant(selectedPlantType);
			
			return new PeaShooter(

				tile.getX(),
				tile.getY()
				
				);
			
			
		case "Sunflower":
			isPlantSelected = false;
			selectedPlantType = null;
			tile.PlaceAPlant(selectedPlantType);
			
			return new SunFlower(
							
					tile.getX(),
					tile.getY()
					
					);
			
			
		case "WallNut":
			isPlantSelected = false;
			selectedPlantType = null;
			tile.PlaceAPlant(selectedPlantType);
			
			return new WallNut(
					
					tile.getX(),
					tile.getY()	
						
					);
			
			
		default:
			isPlantSelected = false;
			selectedPlantType = null;
			return null;
		
		}*/
		
	
	}
	
	

}
