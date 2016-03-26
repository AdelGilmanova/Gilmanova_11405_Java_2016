package Classes;

/**
 * Created by Adel on 17.11.2014.
 */
public class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0, 0);
    }


    public Vector2D add(Vector2D v) {
        return new Vector2D(x + v.getX(), y + v.getY());
    }

    public void add2(Vector2D v) {
        x = x + v.getX();
        y = y + v.getY();
    }

    public Vector2D sub(Vector2D v) {
        return new Vector2D(x - v.getX(), y - v.getY());
    }

    public void sub2(Vector2D v) {
        x = x - v.getX();
        y = y - v.getY();

    }

    public Vector2D mult(double c) {
        return new Vector2D(this.x * c, this.y * c);
    }

    public void mult2(double c) {
        x = x * c;
        y = y * c;
    }

    public String toString() {
        return "(" + x + " ; " + y + ")";
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }


    public double scalarProduct(Vector2D v) {
        double p = x * v.getX() + y * v.getY();
        return p;
    }

    public double cos(Vector2D v) {
        double ch = x * v.getX() + y * v.getY();
        double z = length() * v.length();
        return ch / (double) z;
    }

    public boolean equals(Object obj) {
        Vector2D v = (Vector2D) obj;
        return (x == v.getX() && y == v.getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
