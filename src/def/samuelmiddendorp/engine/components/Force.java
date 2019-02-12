package def.samuelmiddendorp.engine.components;

import dev.samuelmiddendorp.engine.entitites.Entity;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class Force extends Component{

	private Entity e;
		
	private Vector2 friction;
	
	private Vector2 gravity;
	
	public Force(Entity entity) {
		
		e = entity;

		friction = new Vector2();
		
		gravity = new Vector2();
		
	}
	
	public void addForce(Vector2 dir) {
		
		e.acceleration = dir;
		
		e.velocity.Plus(e.acceleration);

		
		e.velocity.Plus(friction);
		
		e.acceleration.Mul(0);
		
		
	}
	@Override
	public void tick() {
		
		friction.x = e.velocity.x*(float)-0.2;
		friction.y = e.velocity.y*(float)-0.05;
		
			
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
