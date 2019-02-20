package com.samuelmiddendorp.engine.entities.obstacles;

import java.awt.Color;
import java.awt.Graphics;

import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.gfx.Camera;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class MoveablePlatform extends Platform{
	
	private Camera camera;

	private Vector2 initial;
	
	public MoveablePlatform(float x, float y, int w, int h, Game game, Camera ca) {
		super(x, y, w, h, game);
		// TODO Auto-generated constructor stub
		camera = ca;
		movable = true;
		initial = new Vector2();
		initial.x = position.x;
		initial.y = position.y;
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		position.x = initial.x - camera.getOffset().x;
		position.y = initial.y - camera.getOffset().y;
		g.setColor(Color.blue);
		g.fillRect((int)position.x, (int)position.y, width, height);
		
		
	}
	
}
