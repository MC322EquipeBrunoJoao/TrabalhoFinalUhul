package com.plantsvszombies.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class MapObject {
	TiledMap tiledMap;
	Lane lanes[];	
	

	public MapObject(TiledMap tiledMap, Lane lanes[]) {
		this.tiledMap = tiledMap;	
		this.lanes = lanes;
			
	}
	
	public TiledMap getTiledMap() {
		return tiledMap;
	}
	
	public Lane getLane(int Y) {
		
		return lanes[Y];
		
	}
	
	public void addZombieToLane(Zombie zombie, int Y) {
		
		lanes[Y].addZombie(zombie);
		
	}
	
	public boolean isThereAZombieInTheLane(int Y) {
		
		return lanes[Y].isThereAZombie();
		
	}
	
	


}
