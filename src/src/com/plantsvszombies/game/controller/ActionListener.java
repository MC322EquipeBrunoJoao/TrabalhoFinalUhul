package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Projectile;
import com.plantsvszombies.game.model.Sun;

public class ActionListener {
	
	private static final ActionListener actionListener = new ActionListener();
	
	private ActionListener() {};
	
	public void notifyNewPlantProjectile(Projectile projectile) {
		EntityController.getInstance().addPlantProjectile(projectile);
	}
	
	public void notifyNewEntity(Entity entity) {
		EntityController.getInstance().addEntity(entity);
	}
	
	public void notifyNewSun(Sun sun) {
		EntityController.getInstance().addSun(sun);
	}
	
	public static ActionListener getInstance() {
		return actionListener;
	}
	
}
