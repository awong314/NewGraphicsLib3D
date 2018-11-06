package Math;

public class Test {
    public static void main(String[] args) {
        float[][] values = new float[][] {
            {1.0f, 2.0f, 3.0f, 4.0f},
            {5.0f, 6.0f, 7.0f, 8.0f},
            {9.0f, 10.0f, 11.0f, 12.0f},
            {13.0f, 14.0f, 15.0f, 16.0f}};
        Matrix3D mat1 = new Matrix3D(values);
        Matrix3D mat2 = new Matrix3D();
        System.out.println(mat1);
        
        
    }
}