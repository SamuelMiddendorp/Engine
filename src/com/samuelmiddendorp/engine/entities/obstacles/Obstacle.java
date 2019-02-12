package com.samuelmiddendorp.engine.entities.obstacles;

import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.entitites.Entity;

public abstract class Obstacle extends Entity{

	public boolean isSpringy;
	
	public Obstacle(float x, float y, Game game) {
		super(x,y,game);
		
	}

}
