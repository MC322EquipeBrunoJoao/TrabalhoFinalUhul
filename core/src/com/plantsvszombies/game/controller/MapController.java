package com.plantsvszombies.game.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.ShopTile;
import com.plantsvszombies.game.model.Tile;

public class MapController {
	
	private static final MapController mapController = new MapController();
	private TiledMap map;
	private ITile[][] matrizMapa = new ITile[12][7];
	private ShopController shopController = ShopController.getInstance();

	private MapController() {};
	
	protected static MapController getInstance() {
		return mapController;
	}
	
	public TiledMap createMap(String path) {
		
		TiledMap map = new TmxMapLoader().load(path);
		this.map = map;
		
		
		for(int i=0; i < 12; i++) {
			for(int j=0; j < 7; j++) {
				
				matrizMapa[i][j] = new Tile(i, j, map);
				
			}
		}
		shopController.createShop(matrizMapa, map,  5);
		
		
		return map;
		
	}
		
	
	public ITile getTile(int xPixels, int yPixels) {
		
		int coluna = xPixels / map.getProperties().get("tilewidth", Integer.class);
		int linha = yPixels / map.getProperties().get("tileheight", Integer.class);
		
		//System.out.println(linha);
		//System.out.println(coluna);
		
		return matrizMapa[coluna][linha];
			
	}

	public TiledMap getMap() {
		return map;
	}

	public void shopInteraction(ITile tile) {
		shopController.shopInteraction(tile, map);
		
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
		
		shopController.displaySunAmount(batch, map);
		
	}

}
