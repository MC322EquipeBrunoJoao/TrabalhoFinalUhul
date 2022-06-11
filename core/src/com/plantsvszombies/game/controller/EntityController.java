package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Pea;
import com.plantsvszombies.game.model.Plant;
import com.plantsvszombies.game.model.Zombie;

public class EntityController {

	private ArrayList<Plant> plants = new ArrayList<Plant>();
	private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	private ArrayList<Pea> plantProjectiles = new ArrayList<Pea>();
	private ArrayList<Entity> totalEntities = new ArrayList<Entity>();
	private ActionListener actionListener = new ActionListener(this);
	
	public void controlEntities(double deltaTime) {		
		for (Zombie zombie : zombies) {
			zombie.move(deltaTime);
			for (Plant plant : plants) {
				if (zombie.overlaps(plant)) {
					plant.takeDamage(zombie.getDamage());
					if (plant.isDead()) {
						plants.remove(plant);
					}
				}
			}
		}
		for (Plant plant : plants) {
			plant.act(actionListener);
		}
		for (Pea projectile : plantProjectiles) {
			projectile.move(deltaTime);
			for (Zombie zombie : zombies) {
				if (projectile.overlaps(zombie)) {
					zombie.takeDamage(projectile.getDamage());
					totalEntities.remove(projectile);
					//plantProjectiles.remove(projectile);
				}
			}
		}
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
