public class Vector2d {

    private double x, y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2d add(Vector2d a) {
        return new Vector2d(this.x + a.getX(),
                this.y + a.getY());
    }

    public Vector2d subtract(Vector2d a) {
        return new Vector2d(this.x - a.getX(),
                this.y - a.getY());
    }

    public Vector2d scalarMultiply(Vector2d a) {
        return new Vector2d(this.x * a.getX(),
                this.y * a.getY());
    }

    public Vector2d vectorMultiply(Vector2d a) {

        return new Vector2d(this.getX() * a.getX(),
                this.getY() * a.getY());
    }
}
