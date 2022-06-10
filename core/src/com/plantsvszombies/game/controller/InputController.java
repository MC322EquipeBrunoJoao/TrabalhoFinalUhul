package com.plantsvszombies.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.plantsvszombies.game.model.Tile;

public class InputController {

	public InputController() {
		// TODO Auto-generated constructor stub
	}

	public void HandleEvent(Tile tile) {
		
		System.out.println(tile.getPositionTileX());
		System.out.println(tile.getPositionTileY());
		
	}
	
	

}
