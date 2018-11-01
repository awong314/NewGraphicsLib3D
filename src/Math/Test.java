package Math;

 class Test {
    public static void main(String[] args) {
        Vector3D vec1 = new Vector3D(1,1,1);
        Vector3D vec2 = new Vector3D(1,1,1);
        System.out.println(vec1.add(vec2));
        
        float values[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Matrix3D mat1 = new Matrix3D(values);
        System.out.println(mat1);
        System.out.println(mat1.elementAt(3, 3));
        Vector3D test = new Vector3D();
        test = mat1.getCol(7);
        System.out.println(test);
    }
}