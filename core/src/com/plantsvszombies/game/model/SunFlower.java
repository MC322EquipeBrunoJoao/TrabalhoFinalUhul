package com.plantsvszombies.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.plantsvszombies.game.controller.ActionListener;

public class SunFlower extends Plant {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long timeLastEnergy = TimeUtils.millis();
	private static Texture sunflowerTexture = new Texture(Gdx.files.internal("sunflower.png"));
	private static int Price = 50;
	
	public SunFlower(float xCenter, float yCenter) {
		super(100, sunflowerTexture, xCenter, yCenter);
	}
 	
	public void act() {
		if (TimeUtils.timeSinceMillis(timeLastEnergy) > 5000) {
			timeLastEnergy = TimeUtils.millis();
			generateSun();
		}
	}
	
	public void generateSun() {
		Vector2 vector = new Vector2();
		vector = getCenter(vector);
		double xIncrement =  MathUtils.random(-90,90);
		double yIncrement = MathUtils.randomSign() * Math.sqrt(8100 - Math.pow(xIncrement, 2));
		ActionListener.getInstance().notifyNewSun(new Sun(vector.x + (float) xIncrement, vector.y + (float) yIncrement));
		
	}
	public static int getPrice() {
		return Price;
	}

}
