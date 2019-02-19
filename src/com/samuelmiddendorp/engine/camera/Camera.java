package com.samuelmiddendorp.engine.camera;

import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.entitites.creatures.Player;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class Camera {

	public Vector2 position;
	
	public Vector2 velocity;
	
	private Player player;
	
	private Game game;
	
	public Camera(Player pl, Game gm) {
		
		position = new Vector2();
		velocity = new Vector2();
		
		player = pl;
		game = gm;
		
	}
	
	public void tick() {		
		
		//velocity = player.velocity;
		
	}
	
}
