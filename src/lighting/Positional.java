package lighting;

import Math.Vector3D;

public class Positional extends Light {
	private float[] direction;
	private Vector3D position;
	
	public Positional() {
		super("Positional");
	}
	
	public float[] getDirection() {
		return direction;
	}
	public void setDirection() {
		
	}
	public void setPosition(Vector3D position) {
		
	}
	public Vector3D getPosition() {
		return this.position;
	}
	
}
