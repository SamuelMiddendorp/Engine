package dev.samuelmiddendorp.engine.utils;

public class Vector2 {
	
	public float x;
	public float y;
		
	// basic constructor with 2 floats;
	
	public Vector2(float x, float y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	// simple constructor which creates a stationary vector, no heading or magnitude
	
	public Vector2() {
		
		x = 0;
		y = 0;
		
	}
	
	// Quality of life calculations;
	
	public void Plus(float a) {
		
		x += a;
		y += a;
		
	}
	
	public void Plus(Vector2 a) {
		
		x += a.x;
		y += a.y;
		
	}
	
	
	public void Min(float a) {
		
		x -= a;
		x -= a;
		
	}
	
	public void Min(Vector2 a) {
		
		x -= a.x;
		x -= a.y;
		
	}
	
	public Vector2 Mul(float a) {
		
		x *= a;
		y *= a;
		
		return(this);
		
	}
	
	// Info 
	
	public float getMag() {
		
		return (float)Math.sqrt((x*x) + (y*y));
		
	}
	
	public float getDir() {
		
		return x / y;
		
	}
	
	// Other adjustments to the vector
	
	public void setMag(float a) {
		
		x = x * (a / getMag());
		y = y * (a / getMag());
		
	}
	
	public void Clamp(float a) {
		
		if(getMag() > a) {
			
			setMag(a);
			
		}
		else {
			
		}
		
	}
	
	
	

	
	
}
