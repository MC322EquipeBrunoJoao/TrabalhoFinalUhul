package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.PeaShooter;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.ShopTile;
import com.plantsvszombies.game.model.SunFlower;
import com.plantsvszombies.game.model.Tile;
import com.plantsvszombies.game.model.WallNut;

public class ShopController {
	
	private static final ShopController shopController = new ShopController();
	private int sunAmount = 50;
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
	
	public void setInitialSunAmount() {
		sunAmount = 50;
	}
	
	public void pickSun() {
		pickSunSound.play();
		sunAmount += 50;
		
	}
	
	
	public void shopInteraction(ITile tile, TiledMap map) {
		
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
		
		
		
		if(tile.getPositionTileY() == 5){
			Cell cell = standardLayer
					.getCell(tile.getPositionTileX(), tile.getPositionTileY());
			
			cell.setTile(null);

		}
		
		
	}
	
	public Plant createPlant(String selectedPlantType, float x, float y) {
		
		Plant plant = null;
	
		switch(selectedPlantType) {
		
		case "PeaShooter":
			if(sunAmount >= PeaShooter.getPrice()) {
				plant = new PeaShooter(x, y);
				sunAmount -= PeaShooter.getPrice();
			}
			break;

							
		case "Sunflower":
			if(sunAmount >= SunFlower.getPrice()) {
				plant = new SunFlower(x, y);
				sunAmount -= SunFlower.getPrice();
			}
				
			break;
			
							
		case "WallNut":
			if(sunAmount >= WallNut.getPrice()) {
				plant = new WallNut(x, y);
				sunAmount -= WallNut.getPrice();				
			}
			break;
			
							
		default:
			break;
		
		}			

		
		return plant;
					
	}
	
	public void displaySunAmount(SpriteBatch batch, TiledMap map) {
		BitmapFont font = new BitmapFont();
		
		
		int tileWidth = map.getProperties().get("tilewidth", Integer.class);
        int tileHeight = map.getProperties().get("tileheight", Integer.class);
        
        Integer sunAmount = this.sunAmount;
        String sunAmountStr = sunAmount.toString();
        GlyphLayout layout = new GlyphLayout(font, sunAmountStr);
        
        
        
        
        font.setColor(Color.BLACK);
        
        font.draw(batch, sunAmount.toString(),
        		
    			Gdx.graphics.getWidth()/2 - 2 * tileWidth - tileWidth/2 + 53 - layout.width/2,
    			Gdx.graphics.getHeight()/2 + 3*tileHeight - 17);
		
		
	}
	
	public void createShop(ITile[][] matrizMapa, TiledMap map, int altura) {
		
		matrizMapa[4][5] = new ShopTile(4, map, "PeaShooter");
		matrizMapa[5][5] = new ShopTile(5, map, "Sunflower");
		matrizMapa[6][5] = new ShopTile(6, map, "WallNut");
		matrizMapa[7][5] = new ShopTile(7, map, null);
		matrizMapa[8][5] =  new ShopTile(8, map, null);
		matrizMapa[9][5] = new ShopTile(9, map, null);
		
		
	}

}
