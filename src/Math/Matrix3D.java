package Math;

import java.util.stream.IntStream;

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

    public Matrix3D(float[] matrix) {
        this.values = new float[][] {
                {matrix[0],  matrix[1],  matrix[2],  matrix[3]},
                {matrix[4],  matrix[5],  matrix[6],  matrix[7]},
                {matrix[8],  matrix[9],  matrix[10], matrix[11]},
                {matrix[12], matrix[13], matrix[14], matrix[15]}
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
    	float cosTheta = (float) Math.cos(degrees);
    	float sinTheta = (float) Math.cos(degrees);
    	float mCosTheta = 1.0f - cosTheta;
    	float uX = axis.getX();
    	float uY = axis.getY();
    	float uZ = axis.getZ();
    	float[][] values = new float[][] {
            {(cosTheta + uX*uX*mCosTheta), (uX*uY*mCosTheta - uZ*sinTheta), (uX*uZ*mCosTheta + uY*sinTheta), 0.0f},
            {(uY*uX*mCosTheta + uZ*sinTheta), (cosTheta + uY*uY*mCosTheta), (uY*uZ*mCosTheta - uX*sinTheta), 0.0f},
            {(uZ*uX*mCosTheta - uY*sinTheta), (uZ*uY*mCosTheta + uX*sinTheta), (cosTheta + uZ*uZ*mCosTheta), 0.0f},
            {0.0f, 0.0f, 0.0f, 1.0f}};
	    Matrix3D rotationMatrix = new Matrix3D(values);
	    return rotationMatrix;
	}

	public Matrix3D createRotationMatrix(float amtX, float amtY, float amtZ) {
        
		Matrix3D temp = rotateX(amtX);
        this.mult(temp);
        temp = rotateY(amtY);
        this.mult(temp);
        temp = rotateZ(amtZ);
        this.mult(temp);
        return this;
	}

    public Matrix3D createScalingMatrix(float amtX, float amtY, float amtZ) {
        this.values = new float[][] {
                {amtX,  0,   0,  0},
                {  0, amtY,  0,  0},
                {  0,   0, amtZ, 0},
                {  0,   0,   0,  1}
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
		return new Matrix3D(temp);
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
        return new Matrix3D(temp);
    }

	public float elementAt(int row, int col) {
	    return this.values[row][col];
    }

    public Vector3D getColVector(int col) {
    	return new Vector3D(this.values[0][col], this.values[1][col], this.values[2][col]);
    }

    public Vector3D getRowVector(int row) {
        return new Vector3D(this.values[row][0], this.values[row][1], this.values[row][2]);
    }
    
    public float[] getColValues(int col) {
    	return new float[] {this.values[0][col], this.values[1][col], this.values[2][col], this.values[3][col]};
    }
    
    public float[] getRowValues(int row) {
    	return new float[] {this.values[row][0], this.values[row][1], this.values[row][2],	 this.values[row][3]};
    }

    public Matrix3D inverse() {
	    /*TODO Derek Return new instance*/
        return null;
    }

    public Matrix3D invert() {
	    /*TODO Derek Mutate current (inverse function w/out new instance)*/
        return null;
    }
    
    /** Functions below to be added later (apply only to current matrix, do not affect vectors **/
    public Matrix3D rotate(float xAmt, float yAmt, float zAmt) {
        /*TODO Derek Mutate current*/
	    return null;
    }

    public Matrix3D rotate(float degrees, Vector3D axis) {
        /*TODO Derek Mutate current*/
        return null;
    }

        public Matrix3D scale(float xAmt, float yAmt, float zAmt) {
        /*TODO Mutate current*/
	    return null;
    }

    public Matrix3D translate(float xAmt, float yAmt, float zAmt) {
        /*TODO Mutate current*/
        return this;
    }
    /** End section **/
    
    public Matrix3D transpose() {
    	float[] temp = this.getValues();
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			this.values[j][i] = temp[(i * 4 + j)];
    		}
    	}
        return this;
    }

    public Matrix3D setCol(int col, Vector3D vector) {
        this.values[0][col] = vector.getX();
        this.values[1][col] = vector.getY();
        this.values[2][col] = vector.getZ();
	    return null;
    }

    public Matrix3D setRow(int row, Vector3D vector) {
        this.values[row][0] = vector.getX();
        this.values[row][1] = vector.getY();
        this.values[row][2] = vector.getZ();
        return null;
    }

    public Matrix3D setElementAt(int row, int col, float value) {
        this.values[row][col] = value;
        return null;
    }
	
	public Matrix3D mult(Matrix3D mat2) {
		float[][] temp = new float[4][4];
        IntStream.range(0, 4).forEachOrdered(row -> {
            IntStream.range(0, 4).forEachOrdered(col -> {
                float[] curRow = this.getRowValues(row);
                float[] mat2Col = mat2.getColValues(col);
                for(int i=0; i<curRow.length; i++) {
                    temp[row][col] += curRow[i] * mat2Col[i];
                }
            });
        });
		return new Matrix3D(temp);
	}
	
	public Vector3D mult(Vector3D vec) {
        float[] temp = new float[4];
        float[] vecValues = new float[] {vec.getX(), vec.getY(), vec.getZ(), 1};
        IntStream.range(0, 4).forEachOrdered(row -> {
            float[] curRow = this.getRowValues(row);
            for(int i=0; i<curRow.length; i++) {
                temp[i] += curRow[i] * vecValues[i];
            }
        });
		return new Vector3D(temp);
	}
	
	public Matrix3D rotateX(float degrees) {
        Matrix3D xRot = new Matrix3D();
        xRot.setElementAt(1, 1, (float) Math.cos(degrees));
        xRot.setElementAt(1, 2, (float) -Math.sin(degrees));
        xRot.setElementAt(2, 1, (float) Math.sin(degrees));
        xRot.setElementAt(2, 2, (float) Math.cos(degrees));
        return xRot;
    }

    public Matrix3D rotateY(float degrees) {
    	Matrix3D yRot = new Matrix3D();
        yRot.setElementAt(0, 0, (float) Math.cos(degrees));
        yRot.setElementAt(0, 2, (float) Math.sin(degrees));
        yRot.setElementAt(2, 0, (float) -Math.sin(degrees));
        yRot.setElementAt(2, 2, (float) Math.cos(degrees));
        return yRot;
    }

    public Matrix3D rotateZ(float degrees) {
    	Matrix3D zRot = new Matrix3D();
        zRot.setElementAt(0, 0, (float) Math.cos(degrees));
        zRot.setElementAt(0, 1, (float) -Math.sin(degrees));
        zRot.setElementAt(1, 0, (float) Math.sin(degrees));
        zRot.setElementAt(1, 1, (float) Math.cos(degrees));
        return zRot;
    }

	public float[] getValues() {
        return new float[] {
                this.values[0][0], this.values[0][1], this.values[0][2], this.values[0][3],
        		this.values[1][0], this.values[1][1], this.values[1][2], this.values[1][3],
        		this.values[2][0], this.values[2][1], this.values[2][2], this.values[2][3],
        		this.values[3][0], this.values[3][1], this.values[3][2], this.values[3][3]
        };
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
