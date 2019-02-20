package com.samuelmiddendorp.engine.entities.obstacles;

import java.awt.Color;
import java.awt.Graphics;


import def.samuelmiddendorp.engine.components.Force;
import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class Platform extends Obstacle{
	
	
	public Vector2 initial;
	
	public Vector2 velocity;

	public Platform(float x, float y, int w, int h, Game game) {
		super(x,y,game);
		
		velocity = new Vector2();
		initial = new Vector2(x,y);
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
		
		position.Plus(velocity);
		//position.y = initial.y + camera.position.y;
		
	}

	@Override
	public Force getForce() {
		// TODO Auto-generated method stub
		return null;
	}

}
