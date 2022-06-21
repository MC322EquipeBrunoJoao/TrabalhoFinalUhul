package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class Tile implements ITile{
	//private int xPixels, yPixels;
	private int linha, coluna;
	private TiledMap map;
	//private boolean isShop = false;
	private boolean isOutOfBounds = false;
	//private boolean isThereAPlant = false;
	private Plant plant;
	
	

	
	public Tile(int coluna, int linha, TiledMap map) {
		//this.xPixels = xPixels;
		//this.yPixels = Gdx.graphics.getHeight() - reversedYPixels;
		this.map = map;
		this.linha = linha;
		this.coluna = coluna;
		
		
		
		

		//if(getPositionTileY() > 4 &&
		//		(2 < getPositionTileX() && getPositionTileX() < 10)) 
		//	isShop = true;
		
		
		if(getPositionTileX() < 3)
			isOutOfBounds = true;
		
		
	}
	
	public int getPositionTileX() {
		
		return coluna;
			
	}
	
	public int getPositionTileY() {
		
		return linha;
		
	}
	
	//public boolean isShop() {
	//	return isShop;
	//}
	
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
	
	
	public boolean IsThereAPlant() {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void PlaceAPlant(String selectedPlantType) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setPlant(Plant plant) {
		
		this.plant = plant;
		
	}
	
}

