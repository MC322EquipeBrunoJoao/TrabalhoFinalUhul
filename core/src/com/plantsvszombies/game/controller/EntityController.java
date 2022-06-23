package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Projectile;
import com.plantsvszombies.game.model.Sun;
import com.plantsvszombies.game.model.Zombie;

public class EntityController {
	
	private static final EntityController entityController = new EntityController();
	private ArrayList<Plant> plants = new ArrayList<Plant>();
	private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private ArrayList<Sun> suns = new ArrayList<Sun>();
	private ArrayList<Projectile> plantProjectiles = new ArrayList<Projectile>();
	private Sound peaHit = Gdx.audio.newSound(Gdx.files.internal("peaHit.mp3"));
	private ArrayList<Entity> totalEntities = new ArrayList<Entity>();
	private long lastGeneration = TimeUtils.millis();
	private TiledMap map;
	
	private EntityController() {};
	
	protected static EntityController getInstance() {
		return entityController;
	}
	
	public void clearEntities() {
		for (int i = plants.size() - 1; i >= 0; i--) {
			plants.remove(i);
		}
		for (int i = zombies.size() - 1; i >= 0; i--) {
			zombies.remove(i);
		}
		for (int i = plantProjectiles.size() - 1; i >= 0; i--) {
			plantProjectiles.remove(i);
		}
		for (int i = suns.size() - 1; i >= 0; i--) {
			suns.remove(i);
		}
		for (int i = totalEntities.size() - 1; i >= 0; i--) {
			totalEntities.get(i).disposeTexture();
			totalEntities.remove(i);
		}
	}
	
	private void controlZombies(double deltaTime) {
		
		ArrayList<Plant> removedPlants = new ArrayList<Plant>();
		ArrayList<Zombie> removedZombies = new ArrayList<Zombie>();
		boolean gameOver = false;
		
		for (Zombie zombie : zombies) {
			zombie.move(deltaTime);
			if (zombie.getX() < 200) {
				removedZombies.add(zombie);
				gameOver = true;
			}
			for (Plant plant : plants) {
				if (zombie.getHitBox().overlaps(plant)) {
					if (zombie.isMoving()) {
						zombie.stop();
					}
					plant.takeDamage(zombie.attack());
					if (plant.isDead()) {
						removedPlants.add(plant);
					}
				}
			}
		}
		
		for (Zombie zombie : zombies) {
			boolean overlaps = false;
			for (Plant plant : plants) {
				if (zombie.getHitBox().overlaps(plant) && !plant.isDead()) {
					overlaps = true;
				}
			}
			if (!overlaps) {
				zombie.resumeMovement();
			}		
		}
		
		for (Plant removedPlant : removedPlants) {
			totalEntities.remove(removedPlant);
			plants.remove(removedPlant);
			removedPlant.disposeTexture();
		}
		
		for (Zombie removedZombie : removedZombies) {
			totalEntities.remove(removedZombie);
			zombies.remove(removedZombie);
			removedZombie.disposeTexture();
		}
		
		if (gameOver) {
			MasterController.getInstance().gameOver();
		}
		
	}
	
	private void controlPlantsActions() {
		for (Plant plant : plants) {
			plant.act();
		}
	}
	
	private void controlProjectiles(double deltaTime) {
		
		ArrayList<Zombie> removedZombies = new ArrayList<Zombie>();
		ArrayList<Projectile> removedProjectiles = new ArrayList<Projectile>();
		
		for (Projectile projectile : plantProjectiles) {
			projectile.move(deltaTime);
			if (projectile.getX() > 1250f) {
				removedProjectiles.add(projectile);
				continue;
			}
			for (Zombie zombie : zombies) {
				if (projectile.overlaps(zombie.getHitBox())) {
					peaHit.play();
					zombie.takeDamage(projectile.getDamage());
					if (zombie.isDead()) {
						removedZombies.add(zombie);
					}
					totalEntities.remove(projectile);
					removedProjectiles.add(projectile);
				}
			}
		}
		
		for (Zombie removedZombie : removedZombies) {
			totalEntities.remove(removedZombie);
			zombies.remove(removedZombie);
			removedZombie.disposeTexture();
		}
		for (Projectile removedProjectile : removedProjectiles) {
			totalEntities.remove(removedProjectile);
			plantProjectiles.remove(removedProjectile);
			removedProjectile.disposeTexture();
		}
	}
	
	public void controlZombieGeneration() {
		if (TimeUtils.timeSinceMillis(lastGeneration) > 5000) {
			
			int tileHeight = map.getProperties().get("tileheight", Integer.class);
			int tileY = (MathUtils.random(0,500)/tileHeight);
			
			Zombie newZombie;
			int n = MathUtils.random(1, 100);
			System.out.println(n);
			if (n <= 10) {
				Texture zombieImage = new Texture(Gdx.files.internal("bucketzombie.png"));
				newZombie = new Zombie(400, 35, zombieImage, 1350, (tileY + 1)*tileHeight - 35 );
			}
			else if (n <= 30) {
				Texture zombieImage = new Texture(Gdx.files.internal("conezombie.png"));
				newZombie = new Zombie(200, 35, zombieImage, 1350, (tileY + 1)*tileHeight - 35);
			}
			else {
				Texture zombieImage = new Texture(Gdx.files.internal("zombie.png"));
				newZombie = new Zombie(100, 35, zombieImage, 1350, (tileY + 1)*tileHeight - 35);
			}
			this.addZombie(newZombie);
			
			lastGeneration = TimeUtils.millis();
		}
	}
	
	public void controlEntities(double deltaTime) {
		
		controlZombies(deltaTime);
		controlPlantsActions();
		controlProjectiles(deltaTime);
		controlZombieGeneration();
		
	}
	
	public ArrayList<Entity> getEntities() {
		return totalEntities;
	}
	
	public void addPlant(Plant plant) {
		plants.add(plant);
		totalEntities.add(plant);
	}
	
	public void addZombie(Zombie zombie) {
		zombies.add(zombie);
		totalEntities.add(zombie);
	}
	
	public void addPlantProjectile(Projectile projectile) {
		plantProjectiles.add(projectile);
		totalEntities.add(projectile);
	}
	
	public void addEntity(Entity entity) {
		totalEntities.add(entity);
	}
	
	public void addSun(Sun sun) {
		suns.add(sun);
		totalEntities.add(sun);
	}
	
	public ArrayList<Sun> getSuns(){
		
		return suns;
		
	}
	
	public void setMap(TiledMap map) {
		this.map = map;
	}
	
	
}
