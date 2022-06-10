package com.plantsvszombies.game.controller;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.plantsvszombies.game.model.IActor;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Tile;

public class InputController {

	public InputController() {
		// TODO Auto-generated constructor stub
	}

	public Plant HandleEvent(Tile tile) {
		
		System.out.println(tile.getPositionTileX());
		System.out.println(tile.getPositionTileY());
		System.out.println(tile.isShop());
		
		//se o tile eh um tile de loja, seleciona nova planta pra criacao
		return null;
		
		//se ha uma planta selecionada, retorna a nova planta
		//return new PeaShooter(...);
		
	}
	
	

}
