package dev.samuelmiddendorp.engine.entitites.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import def.samuelmiddendorp.engine.components.GroundCollider;
import def.samuelmiddendorp.engine.components.Component;
import def.samuelmiddendorp.engine.components.Force;
import def.samuelmiddendorp.engine.components.Gravity;
import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.input.KeyManager;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class Player extends Creature {
	
	protected float speed;
	
	public Vector2 oldPos;
	
	protected KeyManager keymanager;
	
	public Force force;
	
	private List<Component> components;
	

	public Player(float x, float y, Game game) {
		super(x, y, game);
		speed = 20;
		components = new ArrayList<Component>();
		components.add(new Gravity(this));
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0,0);
		width = 50;
		height = 50;
		oldPos = new Vector2();
		
		
		force = new Force(this);
		
		for(Component c: components) {
			c.init();
		}
		
		keymanager = game.keyManager;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)position.x, (int)position.y, 50, 50);
	}

	
	
	public void tick() {
		
		
		
		
		if(keymanager.right) {
			force.addForce(new Vector2(4,0));
		}
		if(keymanager.left) {
			force.addForce(new Vector2(-4,0));
		}
		if(keymanager.up) {
			jump();
		}
		if(keymanager.down) {
			System.out.println(oldPos.x);
			System.out.println(position.x);
		}

		force.tick();
		
		
		for(Component c: components) {
			c.tick();
		}
		oldPos.x = position.x;
		oldPos.y = position.y;
		
		position.Plus(velocity);
		acceleration.Clamp(5);	
		
		
		
		
		
	}
	
	public Force getForce() {
		return force;
	}
	public void jump() {
		if(onGround) {
			velocity.y = 0;
			force.addForce(new Vector2(0,-25));
		}
	}

}
