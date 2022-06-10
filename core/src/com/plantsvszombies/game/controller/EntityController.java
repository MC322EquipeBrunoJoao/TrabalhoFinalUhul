package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.plantsvszombies.game.model.IActor;
import com.plantsvszombies.game.model.IDynamicEntity;

public class EntityController {
	
	private ArrayList<IDynamicEntity> dynamicEntities = new ArrayList<IDynamicEntity>();
	private ArrayList<IActor> actors = new ArrayList<IActor>();
	private ActionListener actionListener;

	
	public void controlPeriodicActions(double deltaTime) {		
		for (IDynamicEntity dynamicEntity : dynamicEntities) {
			dynamicEntity.move(deltaTime);
		}
		for (IActor actor : actors) {
			actor.act(actionListener);
		}
	}
	
	public void addActor(IActor actor) {
		actors.add(actor);
	}
	
	public void addDynamicEntity(IDynamicEntity dynamicEntity) {
		dynamicEntities.add(dynamicEntity);
	}
	
}
