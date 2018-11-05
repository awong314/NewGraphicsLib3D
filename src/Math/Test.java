package Math;

public class Test {
    public static void main(String[] args) {
        Vector3D vec1 = new Vector3D(1,1,1);
        Vector3D vec2 = new Vector3D(1,1,1);
        System.out.println(vec1.add(vec2));

        Matrix3D mat1 = new Matrix3D();
        Matrix3D mat2 = new Matrix3D();

        System.out.println(mat1.add(mat2));
        System.out.println(mat1.sub(mat2));
    }
}