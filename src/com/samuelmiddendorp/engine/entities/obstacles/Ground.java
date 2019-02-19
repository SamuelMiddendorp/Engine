package com.samuelmiddendorp.engine.entities.obstacles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.samuelmiddendorp.engine.camera.Camera;

import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.gfx.ImageLoader;

public class Ground extends Platform {

	private BufferedImage sprite;
	
	public Ground(float x, float y, int w, int h, Game game, Camera ca) {
		super(x, y, w, h, game, ca);
		// TODO Auto-generated constructor stub
		sprite = ImageLoader.LoadImage("/textures/grass.png");
	
	}
	
	public void render(Graphics g) {
		int res = 0;
		while(res < 900) {
			g.drawImage(sprite, res, 450, 64, 64, null);
			res += 64;
		}
		
	}
	
	
	
	
	
	

}
