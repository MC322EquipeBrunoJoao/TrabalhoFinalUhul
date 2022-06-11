package com.plantsvszombies.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.plantsvszombies.game.controller.ActionListener;

public abstract class Plant extends Character{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int linha;
	private int coluna;
	
	public Plant(float health, Texture texture, float x, float y, int width, int height, int linha, int coluna) {
		super(health, texture, x, y, width, height);
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public abstract void act(ActionListener actionListener);

}
