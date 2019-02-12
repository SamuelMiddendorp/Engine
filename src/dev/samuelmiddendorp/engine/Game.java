package dev.samuelmiddendorp.engine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.samuelmiddendorp.engine.display.Display;
import dev.samuelmiddendorp.engine.gfx.Assets;
import dev.samuelmiddendorp.engine.gfx.ImageLoader;
import dev.samuelmiddendorp.engine.gfx.SpriteSheet;
import dev.samuelmiddendorp.engine.input.KeyManager;
import dev.samuelmiddendorp.engine.states.GameState;
import dev.samuelmiddendorp.engine.states.State;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public KeyManager keyManager;
	
	private State gameState;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		this.keyManager = new KeyManager();
		start();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		State.setState(gameState);
	}
	private void tick(){
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		//Draw Here!
		g.clearRect(0, 0, width, height);
		
		//End Drawing!'
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

