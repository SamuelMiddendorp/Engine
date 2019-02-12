package dev.samuelmiddendorp.engine.states;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.samuelmiddendorp.engine.entities.obstacles.Obstacle;
import com.samuelmiddendorp.engine.entities.obstacles.Platform;
import com.samuelmiddendorp.engine.entities.obstacles.SpringyPlatform;

import def.samuelmiddendorp.engine.components.GroundCollider;
import def.samuelmiddendorp.engine.components.BoxCollider;
import def.samuelmiddendorp.engine.components.Component;
import def.samuelmiddendorp.engine.components.Force;
import dev.samuelmiddendorp.engine.Game;
import dev.samuelmiddendorp.engine.entitites.Entity;
import dev.samuelmiddendorp.engine.entitites.creatures.Player;
import dev.samuelmiddendorp.engine.entitites.creatures.RandomObject;
import dev.samuelmiddendorp.engine.gfx.Assets;

public class GameState extends State {
	
	private Player player;
	
	private RandomObject random;
	
	private Game game;
	
	private GroundCollider groundcollider;
	
	private BoxCollider boxcollider;
	
	private List<Entity> entities;
	
	private List<Obstacle> obstacles;

	public GameState(Game game) {
		
		
		this.game = game;
		
		player = new Player(100,100, game);
		obstacles = new ArrayList<Obstacle>();
		obstacles.add(new Platform(500,200,200,50,game));
		obstacles.add(new Platform(0,450,50,200,game));
		obstacles.add(new Platform(100,450,50,200,game));
		obstacles.add(new Platform(200,450,50,200,game));
		obstacles.add(new Platform(300,450,50,200,game));
		obstacles.add(new Platform(400,380,50,200,game));
		entities = new ArrayList<Entity>(); 
		entities.add(player);
		//entities.add(random2);
		//entities.add(random);
		groundcollider = new GroundCollider(entities);
		boxcollider = new BoxCollider(obstacles, player);
		
	}

	public void tick() {
		
		for(Entity e: entities) {
			e.tick();
		}
		groundcollider.tick();
		boxcollider.tick();
		
	}

	public void render(Graphics g) {
		for(Entity e: entities) {
			e.render(g);
		}
		for(Obstacle o: obstacles) {
			o.render(g);
		}
	}

}
