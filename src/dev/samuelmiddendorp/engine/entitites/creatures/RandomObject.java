package dev.samuelmiddendorp.engine.entitites.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import def.samuelmiddendorp.engine.components.Component;
import def.samuelmiddendorp.engine.components.Force;
import def.samuelmiddendorp.engine.components.Gravity;
import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class RandomObject extends Creature {

	private List<Component> components;
	
	private Force force;
	
	public RandomObject(float x, float y, Game game) {
		
		super(x, y, game);
		
		components = new ArrayList<Component>();
		components.add(new Gravity(this));
		
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0,0);

		height = 200;
		width = 200;
		
		force = new Force(this);
		
		for(Component c: components) {
			c.init();
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.drawRect((int)position.x, (int)position.y, width, height);
		
	}

	public void tick() {
		
		force.tick();
		
		for(Component c: components) {
			c.tick();
		}
		
	}

	public Force getForce() {
		// TODO Auto-generated method stub
		return force;
	}

}
