package dev.samuelmiddendorp.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player1, player2;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sheet.png"));
		player1 = sheet.crop(0, 0, width, height);
		player2 = sheet.crop(width, 0, width, height);
		
	}
}
