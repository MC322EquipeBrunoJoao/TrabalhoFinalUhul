package com.plantsvszombies.game.model;

public interface ITile {

	int getPositionTileX();

	int getPositionTileY();

	boolean isOutOfBounds();

	boolean isThereAPlant();
	
	float getX();

	float getY();

	String getPlantType();	
	
	void setPlant(Plant plant);
	
	void setPlantType(String plant);


}
