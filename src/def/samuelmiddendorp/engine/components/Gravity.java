package def.samuelmiddendorp.engine.components;

import dev.samuelmiddendorp.engine.entitites.Entity;
import dev.samuelmiddendorp.engine.utils.Vector2;

public class Gravity extends Component {
	
	private Entity e;
	
	private boolean yes;
	
	private Force force;
	
	private float gravity;

	public Gravity(Entity entity) {
		
		e = entity;
		
	}
	@Override
	public void init() {
		force = e.getForce();
		
	}
	public void tick() {
			
		if(!e.onGround)
			gravity += 0.05;
			else {
				gravity = 0;
			}
		force.addForce(new Vector2(0,gravity));
	}
	
	
	
	

}
