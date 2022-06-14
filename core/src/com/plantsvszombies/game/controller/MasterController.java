package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Zombie;

public class MasterController {
	
	private ActionListener actionListener = new ActionListener(this);
	private EntityController entityController = new EntityController(actionListener);
	private InputController inputController = new InputController();
	private MapController mapController = new MapController();
	private int energy = 0;
	
	public void control(float deltaTime) {
		entityController.controlEntities(deltaTime);
	}
	
	public void incrementEnergy(int increment) {
		energy += increment;
	}
	
	public EntityController getEntityController() {
		return entityController;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void addPlant(Plant plant) {
		entityController.addPlant(plant);
	}
	
	public void addZombie(Zombie zombie) {
		entityController.addZombie(zombie);
	}
	
	public ArrayList<Entity> getEntities() {
		return entityController.getEntities();
	}
	
	public InputController getInputController() {
		return inputController;
	}
	
	public MapController getMapController() {
		return mapController;
		
	}
	
}
