package def.samuelmiddendorp.engine.components;

import java.util.List;

import dev.samuelmiddendorp.engine.entitites.Entity;

public class GroundCollider extends Component{
	 
	private List<Entity> entities;
	
	public GroundCollider(List<Entity> entities) {
		
		this.entities = entities;
		
	}
	
	public void tick() {
		for(Entity e: entities) {
		//basic ground shiet;
/*		if(e.y >= (499 - e.height)) {
			e.onGround = true;
			e.y = (499 - e.height);
		}
		else {
			e.onGround = false;
		}*/
			if((e.position.y + e.velocity.y) >= (472 - e.height)) {
				e.onGround = true;
				e.position.y = (472 - e.height);
			}
			else {
				e.onGround = false;
			}
		}

	
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	

}
