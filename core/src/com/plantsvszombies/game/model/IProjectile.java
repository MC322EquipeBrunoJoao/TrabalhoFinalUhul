package com.plantsvszombies.game.model;

import com.badlogic.gdx.math.Rectangle;

public interface IProjectile {
	void move(double deltaTime);
	boolean overlaps(Rectangle rectangle);
	float getDamage();
	float getX();
	float getY();
}
