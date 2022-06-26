package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.Lane;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.ShopTile;

public class InputController {
	
	private static final InputController inputController = new InputController();
	private boolean isPlantSelected = false;
	private String selectedPlantType = null;

	private InputController() {};
	
	protected static InputController getInstance() {
		return inputController;
	}
	
	public void selectPlant(ITile tile) {
		
		if(tile.getPositionTileY() != 5)
			return ;
		
		
		else {
			
			isPlantSelected = true;
			selectedPlantType = tile.getPlantType();
			return;
			
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

	/*public Plant HandleTileEvent(ITile tile) {
		
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
	}*/

	public boolean isPlantSelected() {

		return isPlantSelected;
	}

	public Plant handlePlantCreation(ITile tile) {
		
		Lane lane = tile.getLane();
		
		try{		
			 return createPlant(tile, lane);	 
		}
		
		catch(NullPointerException e) {
			
			System.out.println("Planta inválida!");
			
			return null;
			
		}
		
		
		
		
	}

	public String getSelectedPlantType() {

		return selectedPlantType;
	}
	
	public void UnselectPlant() {
		
		isPlantSelected = false;
		selectedPlantType = null;
		
	}
	
	public void setSelectedPlantType(String newPlantType) {
		
		selectedPlantType = newPlantType;
		
	}
	
	
}