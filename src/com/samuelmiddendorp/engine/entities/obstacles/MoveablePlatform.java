package com.samuelmiddendorp.engine.entities.obstacles;

import java.awt.Color;
import java.awt.Graphics;

import dev.samuelmiddendorp.engine.Game;

public class MoveablePlatform extends Platform{

	public MoveablePlatform(float x, float y, int w, int h, Game game) {
		super(x, y, w, h, game);
		// TODO Auto-generated constructor stub
		
		movable = true;
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect((int)position.x, (int)position.y, width, height);
		
		
	}
	
}
