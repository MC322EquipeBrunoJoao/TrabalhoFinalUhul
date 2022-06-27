package com.plantsvszombies.game.controller;

import java.util.ArrayList; 

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.plantsvszombies.game.PlantsVsZombies;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.ITile;
import com.plantsvszombies.game.model.Lane;
import com.plantsvszombies.game.model.MapObject;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Sun;
import com.plantsvszombies.game.model.Zombie;
import com.plantsvszombies.game.screens.GameOverScreen;
import com.plantsvszombies.game.screens.GameWonScreen;

public class MasterController {
	
	private static final MasterController masterController = new MasterController();
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
		EntityController.getInstance()
						.controlEntities(deltaTime, MapController
													.getInstance()
													.getMapObject()
										);
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
	
	public MapObject createMap(String path) {
		return MapController.getInstance().createMap(path);
	}
	
	public void shopInteraction(ITile tile) {
		MapController.getInstance().shopInteraction(tile);
	}
	
	/*public Plant HandleEvent(ITile tile) {
		return InputController.getInstance().HandleTileEvent(tile);
	}*/
	
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
		TiledMap map = MapController.getInstance()
									.getMapObject()
									.getTiledMap();
		
        OrthographicCamera camera = new OrthographicCamera(1000, 1000);
        
        float xCamera = map.getProperties().get("tilewidth", Integer.class)
				* map.getProperties().get("width", Integer.class)*.05f;

        float yCamera = map.getProperties().get("tileheight", Integer.class)
        		* map.getProperties().get("height", Integer.class) * .05f;
        
        camera.position.set(xCamera,yCamera,0);
        camera.update();
        return camera;
	}

	public MapObject getMapObject() {
		return MapController.getInstance().getMapObject();
	}

	public boolean isPlantSelected() {
		return InputController.getInstance().isPlantSelected();
	}

	public void selectPlant(ITile tile) {

		InputController.getInstance().selectPlant(tile);
		
	}

	public Plant handlePlantCreation(ITile tile) {
		
		if(tile.isThereAPlant() || tile.isOutOfBounds())
			return null;

		try {
			return createPlant(tile);
		}
		
		catch(NullPointerException e) {
			
			System.out.println("Planta inválida!");
			
			return null;
			
		}
		
		
		
	}
	
	public Plant createPlant(ITile tile) {
		
		String selectedPlantType = InputController.getInstance().getSelectedPlantType();
		Lane lane = tile.getLane();
		
		if(tile.getPositionTileY() != 5) {	
			Plant plant = MapController.getInstance()
					.createPlant(
							selectedPlantType,
							tile.getX(),
							tile.getY(),
							lane
						);		

			tile.setPlant(plant);
			tile.setPlantType(selectedPlantType);
			//isPlantSelected = false;
			//selectedPlantType = null;
			InputController.getInstance().UnselectPlant();
			return plant;
			
		}
		
		else {
			
			//selectedPlantType = tile.getPlantType();
			InputController.getInstance().setSelectedPlantType(tile.getPlantType());
			return null;
				
		}
		
	}
	
	
	
}
