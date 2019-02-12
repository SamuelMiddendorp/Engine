package def.samuelmiddendorp.engine.components;

import java.util.List;

import com.samuelmiddendorp.engine.entities.obstacles.Obstacle;

import dev.samuelmiddendorp.engine.entitites.creatures.Player;
import dev.samuelmiddendorp.engine.utils.AABB;

public class BoxCollider extends Component{

	
	private List<Obstacle> obs;	
	
	private Player p;
	
	public BoxCollider(List<Obstacle> obstacles, Player player) {
		
		obs = obstacles;
		p = player;
		
	}

	public boolean haveCollision(AABB p, AABB o) {
		
		if(p.max.x < o.min.x || p.min.x > o.max.x) { return false; }
		if(p.max.y < o.min.y || p.min.y > o.max.y) { return false; }
				 
				  // No separating axis found, therefor there is at least one overlapping axis
		return true;
		
	}
	public void tick() {
		// TODO Auto-generated method stub
		for(Obstacle o: obs) {
			// general bounds using postori.
			// plz refactor this at some point
				if(haveCollision(p.getBounds(), o.getBounds())) {
					
					
					// box collider also handles the seperate platform types. this mighjt be able to be split pup
					// into mutiple functions but for now, this works.
					
					if((p.oldPos.x <= o.position.x - p.width) 
							) {
						
						
						if(o.movable) {
							p.velocity.x *= 0;
							o.position.x = p.position.x + p.width;
						
						}
						p.position.x = o.position.x - p.width;
						p.velocity.x *= 0;
						
					}
					
					else if((p.oldPos.x >= o.position.x + o.width) 
							) {
						
						p.position.x = o.position.x + o.width;
						p.velocity.x *= 0;
						
					}
					
					else if((p.oldPos.y <= o.position.y -p.height)) {
						
						p.onGround = true;
						p.position.y = o.position.y - p.height;
						if(o.isSpringy) {
							
							p.velocity.y *= -0.7;
						}
						else {
						
							p.velocity.y *= 0;
						}
					}
					
					else if((p.oldPos.y >= o.position.y + o.height)) {
					
						p.position.y = o.position.y + o.height;
						p.velocity.y *= 0;
						
					}
					
					
					
				}
				
				
			}
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
