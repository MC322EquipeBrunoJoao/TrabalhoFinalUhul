package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.Pea;

public class ActionListener {
	
	private MasterController target;
	
	public ActionListener(MasterController target) {
		this.target = target;
	}
	
	public void notifyNewPlantProjectile(Pea projectile) {
		target.getEntityController().addPlantProjectile(projectile);
	}
	
	public void notifyEnergyIncrement(int increment) {
		target.incrementEnergy(increment);
	}
	
}
