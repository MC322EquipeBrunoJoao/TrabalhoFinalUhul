package com.plantsvszombies.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.plantsvszombies.game.model.Tile;

public class MapController {
	TiledMap map;
	Tile[][] matrizMapa = new Tile[12][7];
	

	public MapController() {
		
		
		
	}
	
	public TiledMap createMap(String path) {
		
		TiledMap map = new TmxMapLoader().load(path);
		this.map = map;
		
		
		for(int i=0; i < 12; i++) {
			for(int j=0; j < 7; j++) {
				
				matrizMapa[i][j] = new Tile(i, j, map, "");
				
			}
		}
		matrizMapa[4][5] = new Tile(4, 5, map, "PeaShooter");
		matrizMapa[5][5] = new Tile(5, 5, map, "Sunflower");
		matrizMapa[6][5] = new Tile(6, 5, map, "WallNut");
		
		
		return map;
		
	}
		
	
	public Tile getTile(int xPixels, int yPixels) {
		
		int coluna = xPixels / map.getProperties().get("tilewidth", Integer.class);
		int linha = yPixels / map.getProperties().get("tileheight", Integer.class);
		
		//System.out.println(linha);
		//System.out.println(coluna);
		
		return matrizMapa[coluna][linha];
		
		
	}

}
