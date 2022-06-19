package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Projectile;

public class ActionListener {
	
	private static final ActionListener actionListener = new ActionListener();
	
	private ActionListener() {};
	
	public void notifyNewPlantProjectile(Projectile projectile) {
		EntityController.getInstance().addPlantProjectile(projectile);
	}
	
	public void notifyNewEntity(Entity entity) {
		EntityController.getInstance().addEntity(entity);
	}
	
	public static ActionListener getInstance() {
		return actionListener;
	}
	
}
