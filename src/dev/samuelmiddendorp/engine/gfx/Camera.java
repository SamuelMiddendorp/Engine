package dev.samuelmiddendorp.engine.gfx;

import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.entitites.creatures.Player;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class Camera {

	private Vector2 offset;
	
	private Game game;
	
	private Player player;
	
	public Camera(Game game, Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		this.game = game;
		offset = new Vector2(0,0);
	}
	public void tick() {
		
		if(player.position.x > game.width) {
			
			offset.x = game.width;
			player.position.x = 0;
			
		}
		else if(player.position.x < 0 - player.width) {
			
			offset.x = 0;
			player.position.x = game.width - player.width;
		}
		
	}
	
	public Vector2 getOffset() {
		return offset;
	}
	
	public void setOffset(Vector2 offset) {
		this.offset = offset;
	}
	

}
