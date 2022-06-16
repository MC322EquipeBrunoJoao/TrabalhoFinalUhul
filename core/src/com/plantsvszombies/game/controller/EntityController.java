package com.plantsvszombies.game.controller;

import java.util.ArrayList;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Pea;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Zombie;

public class EntityController {

	private ArrayList<Plant> plants = new ArrayList<Plant>();
	private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private ArrayList<Pea> plantProjectiles = new ArrayList<Pea>();
	private ArrayList<Entity> totalEntities = new ArrayList<Entity>();
	private ActionListener actionListener;
	private long lastGeneration = TimeUtils.millis();
	private TiledMap map;
	
	public EntityController(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
	
	private void controlZombiesAttacks(double deltaTime) {
		
		ArrayList<Plant> removedPlants = new ArrayList<Plant>();
		
		for (Zombie zombie : zombies) {
			zombie.move(deltaTime);
			for (Plant plant : plants) {
				if (zombie.overlaps(plant)) {
					if (zombie.isMoving()) {
						System.out.println("is moving");
						zombie.stop();
					}
					plant.takeDamage(zombie.attack());
					if (plant.isDead()) {
						System.out.println("will resume");
						zombie.resumeMovement();
						totalEntities.remove(plant);
						removedPlants.add(plant);
					}
				}
			}
		}
		
		for (Plant removedPlant : removedPlants) {
			plants.remove(removedPlant);
		}
		
	}
	
	private void controlPlantsActions() {
		for (Plant plant : plants) {
			plant.act(actionListener);
		}
	}
	
	private void controlProjectiles(double deltaTime) {
		
		ArrayList<Zombie> removedZombies = new ArrayList<Zombie>();
		ArrayList<Pea> removedProjectiles = new ArrayList<Pea>();
		
		for (Pea projectile : plantProjectiles) {
			projectile.move(deltaTime);
			if (projectile.getX() > 1250f) {
				removedProjectiles.add(projectile);
				continue;
			}
			for (Zombie zombie : zombies) {
				if (projectile.overlaps(zombie)) {
					System.out.println(zombie.isDead());
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
		}
		for (Pea removedProjectile : removedProjectiles) {
			totalEntities.remove(removedProjectile);
			plantProjectiles.remove(removedProjectile);
		}
	}
	
	public void controlZombieGeneration() {
		if (TimeUtils.timeSinceMillis(lastGeneration) > 3000) {
			
			int tileHeight = map.getProperties().get("tileheight", Integer.class);
			int tileY = (MathUtils.random(0,500)/tileHeight);
			//System.out.println("\n" + tileY + "\n");
			
			Zombie newZombie;
			int n = MathUtils.random(1, 100);
			System.out.println(n);
			if (n <= 10) {
				Texture zombieImage = new Texture(Gdx.files.internal("bucketzombie.png"));
				newZombie = new Zombie(400, 35, zombieImage, 1350, (tileY)*tileHeight - tileHeight/2 + 15);
			}
			else if (n <= 30) {
				Texture zombieImage = new Texture(Gdx.files.internal("conezombie.png"));
				newZombie = new Zombie(200, 35, zombieImage, 1350, (tileY)*tileHeight - tileHeight/2 + 15);
			}
			else {
				Texture zombieImage = new Texture(Gdx.files.internal("zombie.png"));
				newZombie = new Zombie(100, 35, zombieImage, 1350, (tileY)*tileHeight - tileHeight/2 + 15);
			}
			this.addZombie(newZombie);
			
			lastGeneration = TimeUtils.millis();
		}
	}
	
	public void controlEntities(double deltaTime) {
		
		controlZombiesAttacks(deltaTime);
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
	
	public void addPlantProjectile(Pea projectile) {
		plantProjectiles.add(projectile);
		totalEntities.add(projectile);
	}
	
	public void addEntity(Entity entity) {
		totalEntities.add(entity);
	}
	public void setMap(TiledMap map) {
		this.map = map;
	}
	
	
}
