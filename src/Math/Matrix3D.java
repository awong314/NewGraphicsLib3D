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
		for (float f: matrix) {

        }
	}

    public Matrix3D(Vector3D x, Vector3D y, Vector3D z) {
	    /*TODO*/
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
	    /*TODO Derek*/
        return 0;
    }

    public Vector3D getCol(int col) {
        /*TODO Derek*/
        return null;
    }

    public Vector3D getRow(int row) {
        /*TODO Derek*/
        return null;
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
				this.values[0]  + " " + this.values[1]  + " " + this.values[2]  + this.values[3]  + "\n" +
				this.values[4]  + " " + this.values[5]  + " " + this.values[6]  + this.values[7]  + "\n" +
				this.values[8]  + " " + this.values[9]  + " " + this.values[10] + this.values[11] + "\n" +
				this.values[12] + " " + this.values[13] + " " + this.values[14] + this.values[15] + "\n";
	}
}
