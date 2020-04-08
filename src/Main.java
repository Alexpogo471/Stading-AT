public class Main {

    public static void main(String[] args) {

        Vector2d vector2d = new Vector2d(2,6);
        Vector2d vector2d1 = new Vector2d(3,5);
        Vector3d vector3d = new Vector3d(4,6,2);
        Vector3d vector3d1 = new Vector3d(3,9,7);

        System.out.println(vector2d.add(vector2d1));
        System.out.println(vector3d.subtract(vector3d1));
        System.out.println(vector3d.scalarMultiply(vector3d1));
        System.out.println(vector3d.vectorMultiply(vector3d1));

    }
}
