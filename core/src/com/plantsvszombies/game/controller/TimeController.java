package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.model.DynamicEntity;
import com.plantsvszombies.game.model.IActor;
import com.plantsvszombies.game.model.IDynamicEntity;

public class TimeController {
	
	private ArrayList<IDynamicEntity> dynamicEntities;
	private ArrayList<IActor> actors;
	long currentTime = TimeUtils.millis();;
	
	public TimeController() {
		
	}
	
	public void control(double deltaTime, double currentTime) {
		for (IDynamicEntity dinamicEntity : dynamicEntities) {
			dinamicEntity.move(deltaTime);
		}
		for (IActor actor : actors) {
			actor.act(currentTime);
		}
	}
	
	public void addActor() {
		
	}
	
}
