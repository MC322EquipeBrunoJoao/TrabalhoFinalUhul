package com.plantsvszombies.game.controller;

import com.plantsvszombies.game.model.Entity;

public class ActionListener {
	
	private MasterController target;
	
	public ActionListener(MasterController target) {
		this.target = target;
	}
	
	public void notifyNewEntity(Entity entity) {
		target.addEntity(entity);
	}
	
}
