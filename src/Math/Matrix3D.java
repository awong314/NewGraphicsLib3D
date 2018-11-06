package Math;

public class Matrix3D {
	private static final String major = "ROW";
	private float[][] values;
	
	public Matrix3D() {
		this.values = new float[][] {
                {1.0f, 0.0f, 0.0f, 0.0f},
                {0.0f, 1.0f, 0.0f, 0.0f},
                {0.0f, 0.0f, 1.0f, 0.0f},
                {0.0f, 0.0f, 0.0f, 1.0f}
        };
	}

	public Matrix3D(float[][] matrix) {
		this.values = new float[][] {
			{matrix[0][0], matrix[0][1], matrix[0][2], matrix[0][3]},
			{matrix[1][0], matrix[1][1], matrix[1][2], matrix[1][3]},
			{matrix[2][0], matrix[2][1], matrix[2][2], matrix[2][3]},
			{matrix[3][0], matrix[3][1], matrix[3][2], matrix[3][3]}
		};
	}

    public Matrix3D(Vector3D xVec, Vector3D yVec, Vector3D zVec) {
        this.values = new float[][] {
                {xVec.getX(), xVec.getY(), xVec.getZ(), 0},
                {yVec.getX(), yVec.getY(), yVec.getZ(), 0},
                {zVec.getX(), zVec.getY(), zVec.getZ(), 0},
                {    0,           0,           0,       1}
            };
	};

    public Matrix3D createRotationMatrix(float degrees, Vector3D axis) {
	    /*TODO*/
	    return null;
	}

	public Matrix3D createRotationMatrix(float amtX, float amtY, float amtZ) {
        this.values = new float[][] {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return this;
	}

    public Matrix3D createScalingMatrix(float amtX, float amtY, float amtZ) {
        this.values = new float[][] {
                {amtX,  0,   0,  0},
                {0,   amtY,  0,  0},
                {0,     0, amtZ, 0},
                {0,     0,   0,  1}
        };
        return this;
	}

    public Matrix3D createTranslationMatrix(float amtX, float amtY, float amtZ) {
        this.values = new float[][] {
                {1, 0, 0, amtX},
                {0, 1, 0, amtY},
                {0, 0, 1, amtZ},
                {0, 0, 0,   1 }
        };
        return this;
    }

    public Matrix3D createProjectionMatrix(float fov, float width, float height, float near, float far) {
        float aspect = width/height;
        float q = 1.0f / ((float) Math.tan(Math.toRadians(0.5f * fov)));
        float A = q / aspect;
        float B = (near + far) / (near - far);
        float C = (2.0f * near * far) / (near - far);

        this.values = new float[][] {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return this;
    }

    public Matrix3D createCameraMatrix(Vector3D forward, Vector3D up) {
        this.values = new float[][] {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return this;
    }

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
            try {
                throw new Exception("Length mismatch cannot add matrices of different dimensions");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
		return null;
	}

    public Matrix3D sub(Matrix3D mat2) {
        float[] mat1Floats = this.getValues();
        float[] mat2Floats = mat2.getValues();
        float[] temp = new float[mat1Floats.length];

        if (mat1Floats.length == mat2Floats.length) {
            for (int i=0; i<mat1Floats.length; i++) {
                temp[i] = mat1Floats[i] - mat2Floats[i];
            }
        }
        else {
            try {
                throw new Exception("Length mismatch cannot subtract matrices of different dimensions");
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return null;
    }

	public float elementAt(int row, int col) {
	    /*TODO Derek*/
        return 0;
    }

    public Vector3D getCol(int col) {
    	return new Vector3D(this.values[0][col], this.values[1][col], this.values[2][col]);
    }

    public Vector3D getRow(int row) {
        return new Vector3D(this.values[row][0], this.values[row][1], this.values[row][3]);
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
        return new float[] {this.values[0][0], this.values[0][1], this.values[0][2], this.values[0][3],
        					this.values[1][0], this.values[1][1], this.values[1][2], this.values[1][3], 
        					this.values[2][0], this.values[2][1], this.values[2][2], this.values[2][3], 
        					this.values[3][0], this.values[3][1], this.values[3][2], this.values[3][3]};
    }
	
	public static String getMajor() {
		return Matrix3D.major;
	}
	
	public String toString() {
		return "This is a 4x4 matrix with the values: \n" +
				this.values[0][0] + " " + this.values[0][1] + " " + this.values[0][2] + " " + this.values[0][3] + "\n" +
				this.values[1][0] + " " + this.values[1][1] + " " + this.values[1][2] + " " + this.values[1][3] + "\n" +
				this.values[2][0] + " " + this.values[2][1] + " " + this.values[2][2] + " " + this.values[2][3] + "\n" +
				this.values[3][0] + " " + this.values[3][1] + " " + this.values[3][2] + " " + this.values[3][3] + "\n";
	}
}
