package com.samuelmiddendorp.engine.entities.obstacles;

import java.awt.Color;
import java.awt.Graphics;

import def.samuelmiddendorp.engine.components.Force;
import dev.samuelmiddendorp.engine.Game;

public class Platform extends Obstacle{

	public Platform(float x, float y, int w, int h, Game game) {
		super(x,y,game);
		
		width = w;
		height = h;
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int)position.x, (int)position.y, width, height);
		
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Force getForce() {
		// TODO Auto-generated method stub
		return null;
	}

}
