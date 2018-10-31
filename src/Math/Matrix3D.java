package Math;

public class Matrix3D {
	private static Major major = Major.ROW;
	private double[] values;
	
	public Matrix3D() {
		this.values = new double[] {
		        1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0
        };
	}
	
	public Matrix3D(float[] mat) {
		for (float f: mat) {

        }
	}

    public Matrix3D(double[] mat) {
        for (double f: mat) {

        }
    }
	
	public Matrix3D add(Matrix3D mat2) {
		double[] mat1Floats = this.getDoubleValues();
		double[] mat2Floats = mat2.getDoubleValues();
		double[] temp = new double[mat1Floats.length];
		
		if (mat1Floats.length == mat2Floats.length) {
			for (int i=0; i<mat1Floats.length; i++) {
				temp[i] = mat1Floats[i] + mat2Floats[i];
			}
		}
		else {
			System.out.println("Length mismatch cannot add matrices of different dimensions");
			System.exit(0);
		}
		
		return new Matrix3D(temp);
	}
	
	public Matrix3D sub(Matrix3D mat2) {
		return null;
	}
	
	public Matrix3D mult(Matrix3D mat2) {
		return null;
	}
	
	public Matrix3D mult(Vector3D vec2) {
		return null;
	}
	
	public Matrix3D cross() {
		return null;
	}
	
	public float[] getFloatValues() {
		float[] temp = new float[16];
		int i=0;
        for (double d: this.values) {
            temp[i] = (float)d;
		}
		return temp;
	}
	
	public double[] getDoubleValues() {
        return this.values;
	}
	
	public static void setMajor(Major major) {
		Matrix3D.major = major;
	}
	
	public static Major getMajor() {
		return Matrix3D.major;
	}
	
	public String toString() {
		return "This is a 4x4 matrix with the values: \n" +
				this.values[0][0] + " " + this.values[0][1] + " " + this.values[0][2] + this.values[0][3] + "\n" +
				this.values[1][0] + " " + this.values[1][1] + " " + this.values[1][2] + this.values[1][3] + "\n" +
				this.values[2][0] + " " + this.values[2][1] + " " + this.values[2][2] + this.values[2][3] + "\n" +
				this.values[3][0] + " " + this.values[3][1] + " " + this.values[3][2] + this.values[3][3] + "\n";
	}
}
