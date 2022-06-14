package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.controller.ActionListener;

public class SunFlower extends Plant {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long timeLastEnergy = TimeUtils.millis();
	
	public SunFlower(float x, float y, int i, int j) {
		super(100, new Texture(Gdx.files.internal("sunflower.png")), x, y, i, j);
	}
 	
	public void act(ActionListener actionListener) {
		if (TimeUtils.timeSinceMillis(timeLastEnergy) > 5000) {
			timeLastEnergy = TimeUtils.millis();
			generateSun(actionListener);
		}
	}
	
	public void generateSun(ActionListener actionListener) {
		Sun sun = new Sun(x,y);
		actionListener.notifyNewEntity(sun);
	}
}
