package dev.samuelmiddendorp.engine.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.samuelmiddendorp.engine.camera.Camera;
import com.samuelmiddendorp.engine.entities.obstacles.Ground;
import com.samuelmiddendorp.engine.entities.obstacles.MoveablePlatform;
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
import dev.samuelmiddendorp.engine.gfx.ImageLoader;

public class GameState extends State {
	
	private Player player;
	
	private RandomObject random;
	
	private Game game;
	
	private GroundCollider groundcollider;
	
	private BufferedImage groundtile;
	
	private BoxCollider boxcollider;
	
	private Ground ground;
	
	private List<Entity> entities;
	
	private List<Obstacle> obstacles;

	
	public Camera camera;
	
	public GameState(Game game) {
		
		
		this.game = game;
		
		player = new Player(100,450, game);
		camera = new Camera(player, game);
		obstacles = new ArrayList<Obstacle>();
		obstacles.add(new Platform(500,200,200,50,game, camera));
		//obstacles.add(new Platform(0,450,50,200,game));
		//obstacles.add(new SpringyPlatform(100,450,50,200,game));
		//obstacles.add(new Platform(200,450,50,200,game));
		//obstacles.add(new Platform(300,450,50,200,game));
		//obstacles.add(new Platform(400,380,50,200,game));
		obstacles.add(new MoveablePlatform(600,350,50,50,game, camera));

		entities = new ArrayList<Entity>(); 
		
		//entities.add(random2);
		//entities.add(random);
		ground = new Ground(0,0,0,0,game, camera);
		entities.add(player);
		groundcollider = new GroundCollider(entities);
		boxcollider = new BoxCollider(obstacles, player);
		groundtile = ImageLoader.LoadImage("/textures/grass.png");
		
	}

	public void tick() {
		camera.tick();
		for(Entity e: entities) {
			e.tick();
		}
		
		camera.tick();
		groundcollider.tick();
		boxcollider.tick();
		
		
		for(Obstacle o: obstacles) {
			o.tick();
		}
		
	
		
	}

	public void render(Graphics g) {
		for(Entity e: entities) {
			e.render(g);
		}
		for(Obstacle o: obstacles) {
			o.render(g);
		}
		ground.render(g);
		
		
		
	}

}
