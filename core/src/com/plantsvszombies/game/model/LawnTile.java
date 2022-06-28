package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class LawnTile implements ITile{
	private int linha, coluna;
	private TiledMap map;
	private boolean isOutOfBounds = false;
	private Plant plant;
	private String plantType = null;
	private Lane lane;
	
	

	
	public LawnTile(int coluna, int linha, MapObject mapObject) {
		this.map = mapObject.getTiledMap();
		this.linha = linha;
		this.coluna = coluna;
		this.lane = mapObject.getLane(linha);
		

		if(getPositionTileX() < 3)
			isOutOfBounds = true;
		
		
	}
	
	public int getPositionTileX() {
		
		return coluna;
			
	}
	
	public int getPositionTileY() {
		
		return linha;
		
	}

	public boolean isOutOfBounds() {
		return isOutOfBounds;
	}
	
	public float getX() {
		
		
		double xCenterPixels = (coluna + .5) * map.getProperties()
											.get("tilewidth", Integer.class)  ;
		
		return (float)xCenterPixels;
		
		
	}
	
	public float getY() {
		
		
		double yCenterPixels = (linha + .5) * map.getProperties()
											.get("tileheight", Integer.class);
		return (float)yCenterPixels;
		
		
	}

	
	public int getWidth() {
		
		return map.getProperties().get("tilewidth", Integer.class);		
	}
	
	public int getHeight() {
		
		return map.getProperties().get("tileheight", Integer.class);
		
	}
	
	
	public boolean isThereAPlant() {
		if(plant == null || plant.isDead())
			return false;
		
		return true;
	}
	
	public boolean PlaceAPlant(Plant plant) {
		
		this.plant = plant;
		return true;
	}
	
	public Plant getPlant() {
		return this.plant;
	}

	@Override
	public String getPlantType() {
		if(!isThereAPlant())
			return null;
		
		return plantType;
	}
	
	public void setPlantType(String plantType) {
		
		this.plantType = plantType;
		
	}
 
	
	public void setPlant(Plant plant) {
		
		this.plant = plant;
		
	}

	@Override
	public Lane getLane() {
		return lane;
	}
	
}

