package com.plantsvszombies.game.model;

public interface DynamicEntity {
	float[] getVelocity();
	void move(double time);
}