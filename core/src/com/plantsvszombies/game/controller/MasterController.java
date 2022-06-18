package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Zombie;

public class MasterController {
	
	private static final MasterController masterController = new MasterController();
	private EntityController entityController = new EntityController();
	private InputController inputController = new InputController();
	private MapController mapController = new MapController();
	private TiledMap map;
	private int energy = 0;
	
	private MasterController() {};
	
	public static MasterController getInstance() {
		return masterController;
	}
	
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
	
	public TiledMap createMap(String path) {
		
		this.map = mapController.createMap(path);
		entityController.setMap(map);
		return this.map;
		
	}
	
}
