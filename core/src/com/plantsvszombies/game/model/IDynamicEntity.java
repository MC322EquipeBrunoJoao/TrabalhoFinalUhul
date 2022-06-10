package com.plantsvszombies.game.model;

public interface IDynamicEntity {
	float[] getVelocity();
	void move(double time);
}