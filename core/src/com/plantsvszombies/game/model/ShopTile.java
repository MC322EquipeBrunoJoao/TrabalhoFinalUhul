package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class ShopTile implements ITile {
	private String plantType;
	private int coluna;
	private TiledMap map;
	//private Plant plant;
	private Lane lane;

	public ShopTile(int coluna, MapObject mapObject, String plantType) {
		
			this.coluna = coluna;
			this.map = mapObject.getTiledMap();
			this.plantType = plantType;
			this.lane = mapObject.getLane(5);
	}
	
	
	public String getPlantType() {
		return plantType;
	}
	
	public void setPlantType(String plantType) {
		
		this.plantType = plantType;
		
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
	public boolean isThereAPlant() {
		return false;
	}


	@Override
	public boolean isOutOfBounds() {

		return false;
	}

	@Override
	public float getX() {
		
		
		double xCenterPixels = (coluna + .5) * map.getProperties()
											.get("tilewidth", Integer.class)  ;
		
		return (float)xCenterPixels;
		
		
	}
	@Override
	public float getY() {
		
		
		double yCenterPixels = (5 + .5) * map.getProperties()
											.get("tileheight", Integer.class);
		return (float)yCenterPixels;
		
		
	}


	public void setPlant(Plant plant) {

	}


	@Override
	public Lane getLane() {
		return lane;
	}
	
}
