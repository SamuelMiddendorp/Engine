package dev.samuelmiddendorp.engine.states;

import java.awt.Graphics;

public abstract class State {
	
	private static State currenState = null;
	
	
	public static void setState(State state) {
		currenState = state;
	}
	public static State getState() {
		return currenState;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
