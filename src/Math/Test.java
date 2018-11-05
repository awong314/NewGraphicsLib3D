package Math;

public class Test {

	private static Major COLUMN;

	public static void main(String[] args) {
        Vector3D vec1 = new Vector3D(1,2,3);
        Vector3D vec2 = new Vector3D(4,5,6);
        Vector3D vec3 = new Vector3D(7,8,9);
        System.out.println(vec1.add(vec2));
        
        float[] values = {1, 2, 2, 1, 1, 2, 4, 2, 2, 7, 5, 2, -1, 4, -6, 3};
        System.out.println(Matrix3D.getMajor());
        //Matrix3D mat1 = new Matrix3D(vec1, vec2, vec3);
        Matrix3D mat1 = new Matrix3D(values);
        System.out.println(mat1);
        System.out.println(mat1.det3(6.0f, 1.0f, 1.0f, 4.0f, -2.0f, 5.0f, 2.0f, 8.0f, 7.0f));
        System.out.println(mat1.det4(mat1));

	}
}