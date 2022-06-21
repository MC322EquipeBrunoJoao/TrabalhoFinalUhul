package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class ShopTile implements ITile {
	private String plantType;
	private boolean isSelected;
	private int coluna;
	private TiledMap map;

	public ShopTile(int coluna, TiledMap map, String plantType) {
		
			this.coluna = coluna;
			this.map = map;
			this.plantType = plantType;
	}
	
	
	public String getPlantType() {
		return plantType;
	}
	public boolean isSelected() {
		return isSelected;
	}
	
	public void Select() {
		isSelected = true;
		
	}
	
	public void Unselect() {
		isSelected = false;
	}


	@Override
	public int getPositionTileX() {
		// TODO Auto-generated method stub
		return coluna;
	}


	@Override
	public int getPositionTileY() {
		return 5;
	}


	@Override
	public boolean IsThereAPlant() {
		return false;
	}


	@Override
	public boolean isOutOfBounds() {

		return false;
	}


	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void PlaceAPlant(String selectedPlantType) {

		
	}
	public void setPlant(Plant plant) {

	}

}
