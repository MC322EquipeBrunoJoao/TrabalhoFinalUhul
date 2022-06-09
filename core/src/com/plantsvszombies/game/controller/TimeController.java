package com.plantsvszombies.game.controller;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.model.DynamicEntity;

public class TimeController {
	
	private ArrayList<DynamicEntity> dynamicEntities;
	private ArrayList<Actor> actors;
	long currentTime = TimeUtils.millis();;
	
	public TimeController() {
		
	}
		
	
	public void control(double deltaTime, double currentTime) {
		for (DynamicEntity dinamicEntity : dynamicEntities) {
			dinamicEntity.move(deltaTime);
		}
		for (Actor actor : actors) {
			actor.act(currentTime);
		}
	}
}
