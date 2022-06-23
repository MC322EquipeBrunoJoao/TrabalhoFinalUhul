package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.plantsvszombies.game.PlantsVsZombies;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Zombie;
import com.plantsvszombies.game.screens.GameOverScreen;
import com.plantsvszombies.game.screens.StartScreen;

public class MasterController {
	
	private static final MasterController masterController = new MasterController();
	private TiledMap map;
	private int energy = 0;
	private PlantsVsZombies game;
	
	private MasterController() {};
	
	public static MasterController getInstance() {
		return masterController;
	}
	
	public void setGame(PlantsVsZombies game) {
		this.game = game;
	}
	
	public void gameOver() {
		EntityController.getInstance().clearEntities();
		game.setScreen(new GameOverScreen(game));
	}
	
	public void control(float deltaTime) {
		EntityController.getInstance().controlEntities(deltaTime);
	}
	
	public void incrementEnergy(int increment) {
		energy += increment;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void addPlant(Plant plant) {
		EntityController.getInstance().addPlant(plant);
	}
	
	public void addZombie(Zombie zombie) {
		EntityController.getInstance().addZombie(zombie);
	}
	
	public ArrayList<Entity> getEntities() {
		return EntityController.getInstance().getEntities();
	}
	public EntityController getEntityController() {
		return EntityController.getInstance();
	}
	
	public InputController getInputController() {
		return InputController.getInstance();
	}
	
	public MapController getMapController() {
		return MapController.getInstance();
		
	}
	
	public TiledMap createMap(String path) {
		
		this.map = MapController.getInstance().createMap(path);
		EntityController.getInstance().setMap(map);
		return this.map;
		
	}
	
}
