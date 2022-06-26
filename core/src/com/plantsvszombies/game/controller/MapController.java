package com.plantsvszombies.game.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.Lane;
import com.plantsvszombies.game.model.MapObject;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Tile;

public class MapController {
	
	private static final MapController mapController = new MapController();
	private ITile[][] matrizMapa = new ITile[12][7];
	private ShopController shopController = ShopController.getInstance();
	private MapObject mapObject;
	private Lane lanes[] = new Lane[7];
	
	
	private MapController() {};
	
	protected static MapController getInstance() {
		return mapController;
	}
	
	public MapObject createMap(String path) {
		
		TiledMap map = new TmxMapLoader().load(path);
		
		
		
		
		for(int i=0; i < 7; i++) {
			
			lanes[i] = new Lane(i);
			
		}
		
		mapObject = new MapObject(map, lanes);
		
		
		for(int j=0; j < 7; j++) {
			for(int i=0; i < 12; i++) {
				
				matrizMapa[i][j] = new Tile(i, j, mapObject);
				
			}
			
			
		}
		shopController.createShop(matrizMapa, mapObject,  5);


		return mapObject;
		
	}
		
	
	public ITile getTile(int xPixels, int yPixels) {
		
		int coluna = xPixels / mapObject.getTiledMap().getProperties().get("tilewidth", Integer.class);
		int linha = yPixels / mapObject.getTiledMap().getProperties().get("tileheight", Integer.class);
		
		//System.out.println(linha);
		//System.out.println(coluna);
		
		return matrizMapa[coluna][linha];
			
	}

	public MapObject getMapObject() {
		return mapObject;
	}

	public void shopInteraction(ITile tile) {
		shopController.shopInteraction(tile, mapObject.getTiledMap());
		
	}
	
	public void setInitialSunAmount() {
		
		shopController.setInitialSunAmount();
	}

	public void pickSun() {

		shopController.pickSun();
		
	}

	public int getSunAmount() {
		return shopController.getSunAmount();
	}

	public void displaySunAmount(SpriteBatch batch) {
		
		shopController.displaySunAmount(batch, mapObject.getTiledMap());
		
	}

	public Plant createPlant(String selectedPlantType, float x, float y, Lane lane) {
		// TODO Auto-generated method stub
		return shopController.createPlant(selectedPlantType, x, y, lane);
	}

}
