package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class Tile {
	int xPixels, yPixels;
	TiledMap map;

	
	public Tile(int xPixels, int yPixels, TiledMap map) {
		this.xPixels = xPixels;
		this.yPixels = yPixels;
		this.map = map;
		
		
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
	
	

}
