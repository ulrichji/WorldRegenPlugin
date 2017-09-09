package as.minecraft.world;

import java.util.ArrayList;

import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3d;

public class RegenEntity
{
	private String id = null;
	private Vector3d position = null;
	private Vector3d motion = null;
	private Vector2f rotation = null;
	private Float fallDistance = null;
	private Short fire = null;
	private Short air = null;
	private Boolean onGround = null;
	private Boolean noGravity = null;
	private Integer dimension = null;
	private Boolean invulnerable = null;
	private Integer portalCooldown = null;
	private Long uuidMost = null;
	private Long uuidLeast = null;
	private String customName = null;
	private Boolean customNameVisible = null;
	private Boolean silent = null;
	private Object passengers = null;
	private Boolean glowing = null;
	private ArrayList<String> tags = null;
	
	public void setId(String id){ this.id = id; }
	public void setPos(Vector3d pos) { this.position = pos; }
	public void setMotion(Vector3d motion) { this.motion = motion; }
	public void setRotation(Vector2f rot) { this.rotation = rot; }
	public void setFallDistance(float fallDist) { this.fallDistance = fallDist; }
	public void setFire(short fire) { this.fire = fire; }
	public void setAir(short air) { this.air = air; }
	public void setOnGround(boolean onGround) { this.onGround = onGround; }
	public void setNoGravity(boolean noGravity) { this.noGravity = noGravity; }
	public void setDimension(int dimension) { this.dimension = dimension; }
	public void setInvulnerable(boolean invulnerable) { this.invulnerable = invulnerable; }
	public void setPortalCooldown(int portalCooldown) { this.portalCooldown = portalCooldown; }
	public void setUUIDMost(long uuidMost) { this.uuidMost = uuidMost; }
	public void setUUIDLeast(long uuidLeast) { this.uuidLeast = uuidLeast; }
	public void setCustomName(String customName) { this.customName = customName; }
	public void setCustomNameVisible(boolean customNameVisible) { this.customNameVisible = customNameVisible; }
	public void setSilent(boolean silent) { this.silent = silent; }
	public void setPassengers(Object passengers) { this.passengers = passengers; }
	public void setGlowing(boolean glowing) { this.glowing = glowing; }
	public void setTags(ArrayList<String> tags) { this.tags = tags; }
	
	//Test if the entity has set a position.
	public boolean hasPosition()
	{
		return this.position != null;
	}
	
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append("[RegenEntity ");
		if(this.id != null)
			b.append("id=\""+this.id + "\", ");
		if(this.position != null)
			b.append("pos="+this.position.toString()+", ");
		if(this.motion != null)
			b.append("motion="+this.motion.toString()+", ");
		if(this.rotation != null)
			b.append("rot="+this.rotation.toString()+", ");
		if(this.fallDistance != null)
			b.append("fallDist="+this.fallDistance+", ");
		if(this.fire != null)
			b.append("fire="+this.fire+", ");
		if(this.air != null)
			b.append("air="+this.air+", ");
		if(this.onGround != null)
			b.append("onGround="+this.onGround+", ");
		if(this.noGravity != null)
			b.append("noGravity="+this.noGravity+", ");
		if(this.dimension != null)
			b.append("dimension="+this.dimension+", ");
		if(this.invulnerable != null)
			b.append("invulnerable="+this.invulnerable+", ");
		if(this.portalCooldown != null)
			b.append("portalCooldown="+this.portalCooldown+", ");
		if(this.uuidMost != null)
			b.append("uuidMost="+this.uuidMost+", ");
		if(this.uuidLeast != null)
			b.append("uuidLeast="+this.uuidLeast+", ");
		if(this.customName != null)
			b.append("customName=\""+this.customName+"\", ");
		if(this.customNameVisible != null)
			b.append("custonNameVisible="+this.customNameVisible+", ");
		if(this.silent != null)
			b.append("silent="+this.silent+", ");
		if(this.passengers != null)
			b.append("passengers="+this.passengers+", ");
		if(this.glowing != null)
			b.append("glowing="+this.glowing+", ");
		if(this.tags != null)
		{
			b.append("tags=[");
			for(String tag : this.tags)
				b.append("\""+tag+"\",");
			b.append("]");
		}		
		
		b.append("]");
		
		return b.toString();
	}
}
