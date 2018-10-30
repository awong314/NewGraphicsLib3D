package Math;

public class Vector3D {
	private float x;
	private float y;
	private float z;
	private float magnitude;
	
	public Vector3D() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.magnitude = 0;
	}
	
	public Vector3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.magnitude = magnitude(x, y, z);
	}
	
	/**  TODO The methods below will mutate the instance as well as return it **/
	
	public Vector3D normalize() {
		return this;
	}
	
	public Vector3D scale(float scaler) {
		return this;
	}
	
	/**  TODO The methods below will NOT mutate the instance and return new Vector3D **/
	
	public Vector3D mult(Vector3D vec2) {
		return null;
	}
	
	public Vector3D add(Vector3D vec2) {
		return null;
	}
	
	public Vector3D sub(Vector3D vec2) {
		return null;
	}
	
	public Vector3D div(Vector3D vec2) {
		return null;
	}
	
	public Vector3D dot(Vector3D vec2) {
		return null;
	}
	
	public Vector3D cross(Vector3D vec2) {
		return null;
	}
	
	public float magnitude(float x, float y, float z) {
		magnitude = sumOfSquares(x, y, z);
		magnitude = (float) Math.sqrt(magnitude);
		return this.magnitude;
	}
	
	/** Getters and setters for x, y, and z values of Vector3D **/
	public void setX(float x) {
		this.x = x;
	}
	
	public float getX() {
		return this.x;
	}	
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getY() {
		return this.y;	
	}	
	
	public void setZ(float z) {
		this.z = z;
	}
	
	public float getZ() {
		return this.z;
	}
	
	public String toString() {
		return "Vector -> (" + this.x + ", "  + this.y + ", " + this.z + ") magnitude = " + this.magnitude;
	}
	
	/** TODO other methods that do not mutate or return instances of the Vector class **/
	public float angleBetween(Vector3D vec2) {
		// https://www.wikihow.com/Find-the-Angle-Between-Two-Vectors
		return 1;
	}
	
	/**  The Methods below are done  **/
	
	public float[] getDirection() {
		return new float[] {x, y, z};
	}
	
	public void setDirection(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**  Helper functions for math functions  **/
	private float sumOfSquares(float x, float y, float z) {
		float sumOfSquares = (x*x + y*y + z*z);		
		return sumOfSquares;
	}
}
