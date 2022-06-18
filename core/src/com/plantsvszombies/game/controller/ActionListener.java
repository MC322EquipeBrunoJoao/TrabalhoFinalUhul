package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.Entity;
import com.plantsvszombies.game.model.Pea;

public class ActionListener {
	
	private static final ActionListener actionListener = new ActionListener();
	
	private ActionListener() {};
	
	public void notifyNewPlantProjectile(Pea projectile) {
		MasterController.getInstance().getEntityController().addPlantProjectile(projectile);
	}
	
	public void notifyNewEntity(Entity entity) {
		MasterController.getInstance().getEntityController().addEntity(entity);
	}
	
	public static ActionListener getInstance() {
		return actionListener;
	}
	
}
