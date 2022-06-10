package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.plantsvszombies.game.model.Entity;

public class MasterController {
	
	private TimeController timeController = new TimeController();
	private InputController inputController = new InputController();
	private ArrayList<Entity> gameEntities = new ArrayList<Entity>();
	
	public void controlGameEntities() {
		for (Entity entity : gameEntities) {
			
		}
	}
	
	public void addEntity(Entity entity) {
		gameEntities.add(entity);
	}
	
	
}
