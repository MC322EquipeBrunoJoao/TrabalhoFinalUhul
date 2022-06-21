package com.plantsvszombies.game.model;

public interface ITile {

	int getPositionTileX();

	int getPositionTileY();

	boolean IsThereAPlant();

	String getPlantType();

	boolean isOutOfBounds();

	float getX();

	float getY();

	void PlaceAPlant(String selectedPlantType);
	
	boolean isSelected();
	
	void setPlant(Plant plant);

}
