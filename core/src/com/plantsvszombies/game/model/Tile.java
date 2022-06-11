package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class Tile {
	private int xPixels, yPixels;
	private TiledMap map;
	private boolean isShop;
	private boolean isOutOfBounds;
	private String plantType = "PeaShooter";

	
	public Tile(int xPixels, int yPixels, TiledMap map) {
		this.xPixels = xPixels;
		this.yPixels = yPixels;
		this.map = map;
		
		isShop = false;
		if(getPositionTileY() > 4 &&
				(2 < getPositionTileX() && getPositionTileX() < 10)) 
			isShop = true;
		
		isOutOfBounds = false;
		if(getPositionTileX() < 3)
			isOutOfBounds = true;
		
		
	}
	
	public int getPositionTileX() {
		
		int tileWidth = map.getProperties()
						.get("tilewidth", Integer.class);
		
			
		return xPixels / tileWidth;
			
	}
	
	public int getPositionTileY() {
		
		int tileHeight = map.getProperties()
				.get("tileheight", Integer.class);
		
		return yPixels / tileHeight;
		
		
	}
	
	public boolean isShop() {
		return isShop;
	}
	
	public boolean isOutOfBounds() {
		return isOutOfBounds;
	}
	
	public float getX() {
		
		int tileX = getPositionTileX();
		
		double xCenterPixels = (tileX) * map.getProperties()
											.get("tilewidth", Integer.class) - 10 ;
		
		return (float)xCenterPixels;
		
		
	}
	
	public float getY() {
		
		int tileY = getPositionTileY();
		
		double yCenterPixels = (tileY) * map.getProperties()
											.get("tileheight", Integer.class) + 20 ;
		
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
}
