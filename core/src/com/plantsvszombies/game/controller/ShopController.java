package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.ShopTile;
import com.plantsvszombies.game.model.Tile;

public class ShopController {
	
	private static final ShopController shopController = new ShopController();
	private int sunAmount;
	private TiledMap map;
	private Sound pickSunSound = Gdx.audio.newSound(Gdx.files.internal("sunCollected.mp3"));
	
	public ShopController() {
		// TODO Auto-generated constructor stub
	}
	
	protected static ShopController getInstance() {
		return shopController;
	}
	
	public int getSunAmount() {
		return sunAmount;
	}
	
	public void pickSun() {
		pickSunSound.play();
		sunAmount += 50;
		
	}
	
	public void setMap(TiledMap map) {
		this.map = map;
	}
	
	public void shopInteraction(ITile tile) {
		
		TiledMapTileLayer standardLayer = (TiledMapTileLayer) map.getLayers().get("Camada de Tiles 1");
		
		ArrayList<Cell> shop = new ArrayList<Cell>();
		
		for(int i=0; i < 5; i++) {
			
			shop.add(standardLayer.getCell(4 + i, 5));
			
			
		}
		
		//shop.add(standardLayer.getCell(4, 5));
		//shop.add(standardLayer.getCell(5, 5));
		
		for(int i = 0; i < shop.size(); i++) {
			
			shop.get(i)
			.setTile(map.getTileSets().getTileSet("lawn new").getTile(i + 5));
			
		}
		
		
		
		if(tile instanceof ShopTile){
			Cell cell = standardLayer
					.getCell(tile.getPositionTileX(), tile.getPositionTileY());
			
			if(tile.getPlantType() != "") 
				cell.setTile(null);

		}
		
		
	}

}
