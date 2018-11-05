package Math;

public class Matrix3D {
	private static Major major = Major.ROW;
	private float[] values;
	
	public Matrix3D() {
		this.values = new float[] {
		        1.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f, 0.0f,
                0.0f, 0.0f, 0.0f, 1.0f
        };
	}

	public Matrix3D(float[] matrix) {
		this.values = matrix;
	}

    public Matrix3D(Vector3D x, Vector3D y, Vector3D z) {
	    /*TODO test column major vector after learning to properly set value*/
    	if(major == Major.ROW){
    		this.values = new float[] {x.getX(), x.getY(), x.getZ(), 0.0f,
    								   y.getX(), y.getY(), y.getZ(), 0.0f,
    								   z.getX(), z.getY(), z.getZ(), 0.0f,
    								   0.0f,     0.0f,     0.0f,     1.0f};
    	}
    	if(major == Major.COLUMN) {
    		this.values = new float[] {x.getX(), y.getX(), z.getX(), 0.0f,
    								   x.getY(), y.getY(), z.getY(), 0.0f,
    								   x.getZ(), y.getZ(), z.getZ(), 0.0f,
    								   0.0f,     0.0f,     0.0f,     1.0f};
    	}
    }

    public Matrix3D createRotationMatrix(float degrees, Vector3D axis) {
	    /*TODO*/
	    return null;
	}

	public Matrix3D createRotationMatrix(float amtX, float amtY, float amtZ) {
	    /*TODO*/
        return null;
	}

    public Matrix3D createScalingMatrix(float amtX, float amtY, float amtZ) {
	    /*TODO*/
	    return null;
	}

    public Matrix3D createTranslationMatrix(float amtX, float amtY, float amtZ) {
        /*TODO*/
        return null;
    }

    public Matrix3D createProjectionMatrix(float fov, float width, float height, float near, float far) {
        /*TODO*/
        return null;
    }

    public Matrix3D createCameraMatrix(Vector3D forward, Vector3D up) {
        /*TODO*/
        return null;
    }

	//TODO Fix math
	public Matrix3D add(Matrix3D mat2) {
		float[] mat1Floats = this.getValues();
        float[] mat2Floats = mat2.getValues();
        float[] temp = new float[mat1Floats.length];
		
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

	public float elementAt(int row, int col) {
		if(row < 0 || row > 3 || col < 0 || col > 3) {
			System.out.println("Matrix index out of bounds, must be an integer between 0 and 3.");
			System.exit(0);
			return -1;
		}
	    return this.values[4*row + col];
    }

    public Vector3D getCol(int col) {
    	switch(col) {
    		case 0:	return new Vector3D(this.values[0], this.values[4], this.values[8]);
    		case 1:	return new Vector3D(this.values[1], this.values[5], this.values[9]);
    		case 2:	return new Vector3D(this.values[2], this.values[6], this.values[10]);
    		case 3:	return new Vector3D(this.values[3], this.values[7], this.values[11]);
    		default:
    			System.out.println("Column index out of bounds, must be an integer between 0 and 3.");
    			System.exit(0);
    			return null;
    	}
    }

    public Vector3D getRow(int row) {
    	switch(row) {
			case 0:	return new Vector3D(this.values[0], this.values[1], this.values[2]);
			case 1:	return new Vector3D(this.values[4], this.values[5], this.values[6]);
			case 2:	return new Vector3D(this.values[8], this.values[9], this.values[10]);
			case 3:	return new Vector3D(this.values[12], this.values[13], this.values[14]);
			default:
				System.out.println("Row index out of bounds, must be an integer between 0 and 3.");
				System.exit(0);
				return null;
    	}
    }

    public Matrix3D inverse() {
	    /*TODO Derek Return new instance*/
        return null;
    }

    public Matrix3D invert() {
	    /*TODO Derek Mutate current*/
        return null;
    }

    public Matrix3D rotate(float xAmt, float yAmt, float zAmt) {
        /*TODO Derek Mutate current*/
	    return null;
    }

    public Matrix3D rotate(float degrees, Vector3D axis) {
        /*TODO Derek Mutate current*/
        return null;
    }

    public Matrix3D rotateX(float degrees) {
        /*TODO Mutate current*/
        return null;
    }

    public Matrix3D rotateY(float degrees) {
        /*TODO Mutate current*/
        return null;
    }

    public Matrix3D rotateZ(float degrees) {
        /*TODO Mutate current*/
        return null;
    }

    public Matrix3D scale(float xAmt, float yAmt, float zAmt) {
        /*TODO Mutate current*/
	    return null;
    }

    public Matrix3D translate(float xAmt, float yAmt, float zAmt) {
        /*TODO Mutate current*/
        return null;
    }

    public Matrix3D transpose() {
        /*TODO Mutate current*/
        return null;
    }

    public Matrix3D setCol(int col, Vector3D vector) {
        /*TODO Mutate current*/
	    return null;
    }

    public Matrix3D setRow(int row, Vector3D vector) {
        /*TODO Mutate current*/
        return null;
    }

    public Matrix3D setElementAt(int row, int col, float value) {
        /*TODO Mutate current*/
        return null;
    }

	public Matrix3D sub(Matrix3D mat2) {
		return null;
	}
	
	public Matrix3D mult(Matrix3D mat2) {
		/*TODO Derek*/
		return null;
	}
	
	public Matrix3D mult(Vector3D vec2) {
		/*TODO Derek*/
		return null;
	}
	
	public Matrix3D cross() {
		return null;
	}
	
	public float[] getValues() {
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
				this.values[0]  + " " + this.values[1]  + " " + this.values[2] + " " + this.values[3]  + "\n" +
				this.values[4]  + " " + this.values[5]  + " " + this.values[6] + " " + this.values[7]  + "\n" +
				this.values[8]  + " " + this.values[9]  + " " + this.values[10] + " " + this.values[11] + "\n" +
				this.values[12] + " " + this.values[13] + " " + this.values[14] + " " + this.values[15] + "\n";
	}
	
	/************* Functions to get the determinant of a 4 x 4 matrix -> det3 to get determinant of 3 x 3 to be used in det4 function *************/
	public float det3(float a, float b, float c, float d, float e, float f, float g, float h, float i) {
		float det3 = (a*(e*i - f*h)) - (b*(d*i - f*g)) + (c*(d*h - e*g));
		return det3;		
	}
	public float det4(Matrix3D matrix) {
		float det4;
		det4 = (this.values[0] * det3(this.values[5], this.values[6], this.values[7], this.values[9], this.values[10], this.values[11],this.values[13], this.values[14], this.values[15]))
			- (this.values[1] * det3(this.values[4], this.values[6], this.values[7], this.values[8], this.values[10], this.values[11],this.values[12], this.values[14], this.values[15]))
			+ (this.values[2] * det3(this.values[4], this.values[5], this.values[7], this.values[8], this.values[9], this.values[11],this.values[12], this.values[13], this.values[15]))
			- (this.values[3] * det3(this.values[4], this.values[5], this.values[6], this.values[8], this.values[9], this.values[10],this.values[12], this.values[13], this.values[14]));
		return det4;
	}
	/************* Helper functions for obtaining matrix inverse *************/
	
	public Matrix3D matMinors(Matrix3D matrix) {
		return new Matrix3D();
	}
	public Matrix3D matCofactors(Matrix3D matrix) {
		return matrix;
	}
}
