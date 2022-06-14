package com.plantsvszombies.game.controller;

import java.util.ArrayList;

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
			for (Zombie zombie : zombies) {
				if (projectile.overlaps(zombie)) {
					System.out.println(zombie.isDead());
					zombie.takeDamage(projectile.getDamage());
					if (zombie.isDead()) {
						totalEntities.remove(zombie);
						removedZombies.add(zombie);
					}
					totalEntities.remove(projectile);
					removedProjectiles.add(projectile);
				}
			}
		}
		
		for (Zombie removedZombie : removedZombies) {
			zombies.remove(removedZombie);
		}
		for (Pea removedProjectile : removedProjectiles) {
			plantProjectiles.remove(removedProjectile);
		}
	}
	
	public void controlZombieGeneration() {
		if (TimeUtils.timeSinceMillis(lastGeneration) > 3000) {
			this.addZombie(Zombie.randomSpawn());
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
}
