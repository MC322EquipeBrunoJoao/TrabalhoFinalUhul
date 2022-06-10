package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.plantsvszombies.game.model.Entity;

public class MasterController {
	
	private ActionListener actionListener = new ActionListener(this);
	private EntityController timeController = new EntityController();
	private InputController inputController = new InputController();
	private ArrayList<Entity> gameEntities = new ArrayList<Entity>();
	
	public void control(long deltaTime) {
		timeController.controlPeriodicActions(deltaTime, actionListener);;
	}
	
	public void addEntity(Entity entity) {
		gameEntities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		gameEntities.remove(entity);
	}
	
	
}
