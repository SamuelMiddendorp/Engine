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
			// general bounds using priori.
			// plz refactor this at some point
				if(haveCollision(p.getBounds(), o.getBounds())) {
					
					
					if((p.oldPos.x <= o.position.x - p.width) 
							) {
						System.out.print("Jaas links");
						p.position.x = o.position.x - p.width;
						p.velocity.x *= 0;
						
					}
					else if((p.oldPos.x >= o.position.x + o.width) 
							) {
						System.out.print("Jaas rechts");
						p.position.x = o.position.x + o.width;
						p.velocity.x *= 0;
						
					}
					else if((p.oldPos.y <= o.position.y -p.height)) {
						System.out.print("Jaas boven");
						p.onGround = true;
						p.position.y = o.position.y - p.height;
						if(o.isSpringy) {
							
							p.velocity.y *= -0.9;
						}
						else {
						
							p.velocity.y *= 0;
						}
					}
					else if((p.oldPos.y >= o.position.y + o.height)) {
						System.out.print("Jaas onder");
						p.position.y = o.position.y + o.height;
						p.velocity.y *= 0;
						
					}
					
					/*else if((p.oldPos.x >= o.position.x ) 
							) {
						
						p.position.x = o.position.x + o.width;
						
					}
					else if((p.oldPos.y >= o.position.y ) 
							) {
						
						p.position.y = o.position.y - p.height;
						
					}
					else if((p.oldPos.y <= o.position.y) 
							) {
						
						p.position.y = o.position.y + o.height;
						
					}*/
					
					
				}
				
				
			}
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}