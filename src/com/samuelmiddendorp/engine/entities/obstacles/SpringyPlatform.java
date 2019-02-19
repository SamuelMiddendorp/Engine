package com.samuelmiddendorp.engine.entities.obstacles;

import java.awt.Color;
import java.awt.Graphics;

import com.samuelmiddendorp.engine.camera.Camera;

import dev.samuelmiddendorp.engine.Game;

public class SpringyPlatform extends Platform{

	public SpringyPlatform(float x, float y, int w, int h, Game game, Camera ca) {
		super(x,y,w,h,game,ca);
		
		width = w;
		height = h;
		isSpringy = true;
		
	}
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect((int)position.x, (int)position.y, width, height);
		
		
	}

}
