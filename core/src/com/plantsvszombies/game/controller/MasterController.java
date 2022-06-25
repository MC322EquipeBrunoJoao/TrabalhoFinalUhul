package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.plantsvszombies.game.PlantsVsZombies;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Sun;
import com.plantsvszombies.game.model.Zombie;
import com.plantsvszombies.game.screens.GameOverScreen;
import com.plantsvszombies.game.screens.GameWonScreen;
import com.plantsvszombies.game.screens.StartScreen;

public class MasterController {
	
	private static final MasterController masterController = new MasterController();
	private int energy = 0;
	private PlantsVsZombies game;
	
	private MasterController() {};
	
	public static MasterController getInstance() {
		return masterController;
	}
	
	public void setInitialGameConditions() {
		EntityController.getInstance().setInitialConditions();
		MapController.getInstance().setInitialSunAmount();
	}
	
	public void setGame(PlantsVsZombies game) {
		this.game = game;
	}
	
	public void gameOver() {
		game.setScreen(new GameOverScreen(game));
	}
	
	public void gameWon() {
		game.setScreen(new GameWonScreen(game));
	}
	
	public void control(float deltaTime) {
		EntityController.getInstance().controlEntities(deltaTime, MapController.getInstance().getMap());
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
		
		return MapController.getInstance().createMap(path);
		
	}
	
	public void shopInteraction(ITile tile) {
		
		MapController.getInstance().shopInteraction(tile);
	}
	
	public Plant HandleEvent(ITile tile) {
		return InputController.getInstance().HandleTileEvent(tile);
	}
	
	public ITile getTile(int xPixels, int yPixels) {
		
		return MapController.getInstance().getTile(xPixels, yPixels);
		
		
	}
	
	public ArrayList<Sun> getSuns(){
		return EntityController.getInstance().getSuns();
	}
	
	public ArrayList<Zombie> getZombies() {
		return EntityController.getInstance().getZombies();
	}
	
	public void pickSun(Sun sun) {
		
		MapController.getInstance().pickSun();
		EntityController.getInstance().getSuns().remove(sun);
		EntityController.getInstance().getEntities().remove(sun);
	}
	
	public int getSunAmount() {
		return MapController.getInstance().getSunAmount();
	}
	
	public void displaySunAmount(SpriteBatch batch) {
		MapController.getInstance().displaySunAmount(batch);
		
	}

	public OrthographicCamera setCamera() {
		TiledMap map = MapController.getInstance().getMap();
		
        OrthographicCamera camera = new OrthographicCamera(1000, 1000);
        
        float xCamera = map.getProperties().get("tilewidth", Integer.class)
				* map.getProperties().get("width", Integer.class)*.05f;

        float yCamera = map.getProperties().get("tileheight", Integer.class)
        		* map.getProperties().get("height", Integer.class) * .05f;
        
        camera.position.set(xCamera,yCamera,0);
        camera.update();
        return camera;
	}
	
	
	
}
