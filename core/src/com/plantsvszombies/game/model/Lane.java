package com.plantsvszombies.game.model;

import java.util.ArrayList;

public class Lane {
	
	private int Y;
	private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	
	public Lane(int Y) {
		
		this.Y = Y;
		
	}
	
	public void addZombie(Zombie zombie) {
		zombies.add(zombie);
	}
	
	public void removeZombie(Zombie zombie) {
		zombies.remove(zombie);
	}
	
	public boolean isThereAZombie() {
		
		if(zombies.isEmpty())
			return false;
		return true;
		
	}

}
