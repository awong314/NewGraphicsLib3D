package Math;

public abstract class Matrix {
	private float values[][];
	
	public Matrix(int size) {
		this.values = new float[size][size];
		int count = -1;
		for(int i = 0; i < size; i++) {
			count++;
			for(int j = 0; j < size; j++) {
				if(count == j && count == i) {
					this.values[i][j] = 1.0f;
				}
				else this.values[i][j] = 0.0f;
			}
		}
	}
	
	public Matrix(float[][] matrix) {
		int size = matrix.length;
		this.values = new float[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				this.values[i][j] = matrix[i][j];
			}
		}
	}
	/*public Matrix(Vector[] vecArray) {
	        
	}

	public Matrix createRotationMatrix(float degrees, Vector axis) {
		    return null;
	}*/

	public Matrix createRotationMatrix(float[] rotArray) {
		return this;
	}

	public Matrix createScalingMatrix(float[] scaleArray) {
		return this;
	}
	public Matrix createTranslationMatrix(float[] translationArray) {

        return this;
    }
    public Matrix createProjectionMatrix(float fov, float width, float height, float near, float far) {
        float aspect = width/height;
        float q = 1.0f / ((float) Math.tan(Math.toRadians(0.5f * fov)));
        float A = q / aspect;
        float B = (near + far) / (near - far);
        float C = (2.0f * near * far) / (near - far);

        return this;
    }
    
	/********** The functions will mutate the current matrix and return it ************/
	public Matrix add(Matrix mat2) {
		return this;
	}
	public Matrix sub(Matrix mat2) {
		return this;
	}
	public Matrix multMatrix(Matrix mat2) {
		return this;
	}
	/*public Matrix mult(Vector vec2) {
		return null;
	}*/
	public Matrix inverse() {
		return this;
	}
    


/*
    public Matrix createCameraMatrix(Vector forward, Vector up) {
        
    }

	public Matrix add(Matrix mat2) {
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

    public Matrix sub(Matrix mat2) {
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
	    return this.values[row][col];
    }

    public Vector getColVector(int col) {
    	return new Vector(this.values[0][col], this.values[1][col], this.values[2][col]);
    }

    public Vector getRowVector(int row) {
        return new Vector(this.values[row][0], this.values[row][1], this.values[row][2]);
    }
    
    public float[] getColValues(int col) {
    	return new float[] {this.values[0][col], this.values[1][col], this.values[2][col], this.values[3][col]};
    }
    
    public float[] getRowValues(int row) {
    	return new float[] {this.values[row][0], this.values[row][1], this.values[row][2],	 this.values[row][3]};
    }

    public Matrix invert() {
        return null;
    }

    public Matrix rotate(float[] rotArray) {
	    return null;
    }

    public Matrix rotate(float degrees, Vector axis) {
        return null;
    }

    public Matrix rotateX(float degrees) {
        return null;
    }

    public Matrix rotateY(float degrees) {
        return null;
    }

    public Matrix rotateZ(float degrees) {
        return null;
    }

    public Matrix scale(float[] scaleArray) {
	    return null;
    }

    public Matrix translate(float[] translateArray) {
        return null;
    }

    public Matrix transpose() {
        return null;
    }

    public Matrix setCol(int col, Vector vector) {
	    return null;
    }

    public Matrix setRow(int row, Vector vector) {
        return null;
    }

    public Matrix setElementAt(int row, int col, float value) {
        return null;
    }
	
	public Matrix cross() {
		return null;
	}
	
	public float[] getValues() {
        return new float[] {};
    }
	
	
	public String toString() {
		return "This is a 4x4 matrix with the values: \n";
	}*/
	
}
