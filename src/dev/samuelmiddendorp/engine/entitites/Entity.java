package dev.samuelmiddendorp.engine.entitites;

import java.awt.Graphics;

import def.samuelmiddendorp.engine.components.Force;
import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.utils.AABB;
import dev.samuelmiddendorp.engine.utils.Vector2;

public abstract class Entity {
	
	public Vector2 position;
	
	public int width, height;
	
	public boolean onGround = false;
	
	public boolean canJump = false;
	
	public boolean isSolid = true;
	
	
	public boolean onScreen = true;
	
	public Vector2 velocity;
	
	public Vector2 acceleration;
	
	public Game game;
	
	
	public Entity(float x, float y, Game game) {
		this.game = game;

		position = new Vector2(x,y);
		
	}
		
	public AABB getBounds() {
		
		return new AABB(new Vector2(position.x, position.y), new Vector2(position.x + width, position.y + height)); 
		
	}
	public abstract void render(Graphics g);
	
	public abstract void tick();
	
	public abstract Force getForce();
	
	
}
