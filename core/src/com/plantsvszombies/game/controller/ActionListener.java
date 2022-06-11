package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Pea;
import com.plantsvszombies.game.model.Plant;

public class ActionListener {
	
	private EntityController target;
	
	public ActionListener(EntityController target) {
		this.target = target;
	}
	
	public void notifyNewPlantProjectile(Pea projectile) {
		target.addPlantProjectile(projectile);
	}
	
}
