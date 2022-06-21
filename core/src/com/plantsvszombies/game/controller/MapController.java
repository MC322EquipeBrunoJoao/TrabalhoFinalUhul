package com.plantsvszombies.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.ShopTile;
import com.plantsvszombies.game.model.Tile;

public class MapController {
	
	private static final MapController mapController = new MapController();
	TiledMap map;
	ITile[][] matrizMapa = new ITile[12][7];

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
		matrizMapa[4][5] = new ShopTile(4, map, "PeaShooter");
		matrizMapa[5][5] = new ShopTile(5, map, "Sunflower");
		matrizMapa[6][5] = new ShopTile(6, map, "WallNut");
		matrizMapa[7][5] = new ShopTile(7, map, null);
		matrizMapa[8][5] =  new ShopTile(8, map, null);
		matrizMapa[9][5] = new ShopTile(9, map, null);
		
		
		return map;
		
	}
		
	
	public ITile getTile(int xPixels, int yPixels) {
		
		int coluna = xPixels / map.getProperties().get("tilewidth", Integer.class);
		int linha = yPixels / map.getProperties().get("tileheight", Integer.class);
		
		//System.out.println(linha);
		//System.out.println(coluna);
		
		return matrizMapa[coluna][linha];
		
		
	}

}
