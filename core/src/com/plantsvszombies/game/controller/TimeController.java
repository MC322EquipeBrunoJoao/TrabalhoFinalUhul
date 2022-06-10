package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.model.IActor;
import com.plantsvszombies.game.model.IDynamicEntity;

public class TimeController {
	
	private ArrayList<IDynamicEntity> dynamicEntities = new ArrayList<IDynamicEntity>();
	private ArrayList<IActor> actors = new ArrayList<IActor>();
	long currentTime = TimeUtils.millis();
	
	public void controlPeriodicActions(double deltaTime) {		
		for (IDynamicEntity dinamicEntity : dynamicEntities) {
			dinamicEntity.move(deltaTime);
		}
		for (IActor actor : actors) {
			actor.act();
		}
	}
	
	public void addActor(IActor actor) {
		actors.add(actor);
	}
	
	public void addDynamicEntity(IDynamicEntity dynamicEntity) {
		dynamicEntities.add(dynamicEntity);
	}
	
}
