package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Tile {
	//private int xPixels, yPixels;
	private int linha, coluna;
	private TiledMap map;
	private boolean isShop = false;
	private boolean isOutOfBounds = false;
	private boolean isSelected = false;
	private boolean isThereAPlant = false;
	private String plantType = "PeaShooter";

	
	public Tile(int coluna, int linha, TiledMap map, String plantType) {
		//this.xPixels = xPixels;
		//this.yPixels = Gdx.graphics.getHeight() - reversedYPixels;
		this.map = map;
		this.linha = linha;
		this.coluna = coluna;
		
		this.plantType = plantType;
		
		
		

		if(getPositionTileY() > 4 &&
				(2 < getPositionTileX() && getPositionTileX() < 10)) 
			isShop = true;
		
		
		if(getPositionTileX() < 3)
			isOutOfBounds = true;
		
		
	}
	
	public int getPositionTileX() {
		
		return coluna;
			
	}
	
	public int getPositionTileY() {
		
		return linha;
		
	}
	
	public boolean isShop() {
		return isShop;
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
	
	public String getPlantType() {
		return plantType;
	}
	
	public int getWidth() {
		
		return map.getProperties().get("tilewidth", Integer.class);		
	}
	
	public int getHeight() {
		
		return map.getProperties().get("tileheight", Integer.class);
		
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
	
	public boolean IsThereAPlant() {
		return isThereAPlant;		
	}
	
	public void PlaceAPlant(String plantType) {
		
		isThereAPlant = true;
		this.plantType = plantType;		
	}
	
}

