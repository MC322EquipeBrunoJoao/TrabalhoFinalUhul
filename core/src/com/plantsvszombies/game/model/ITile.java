package com.plantsvszombies.game.model;

public interface ITile {

	int getPositionTileX();

	int getPositionTileY();

	boolean IsThereAPlant();
	
	boolean isOutOfBounds();
	
	float getX();

	float getY();

	String getPlantType();	

	boolean isSelected();
	
	void setPlant(Plant plant);

}
