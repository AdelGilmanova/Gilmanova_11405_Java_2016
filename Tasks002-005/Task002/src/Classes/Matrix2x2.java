package Classes;

/**
 * Created by Adel on 17.11.2014.
 */
public class Matrix2x2 {
    private double a[][] = new double[2][2];

    public Matrix2x2(double a00, double a01, double a10, double a11) {
        a[0][0] = a00;
        a[0][1] = a01;
        a[1][0] = a10;
        a[1][1] = a11;
    }

    public Matrix2x2() {
        this(0, 0, 0, 0);
    }

    public Matrix2x2(double c) {
        this(c, c, c, c);
    }

    public Matrix2x2(double a[][]) {
        this(a[0][0], a[0][1], a[1][0], a[1][1]);
    }

    public Matrix2x2 add(Matrix2x2 m) {
        return new Matrix2x2(a[0][0] + m.getA00(), a[0][1] + m.getA01(), a[1][0] + m.getA10(), a[1][1] + m.getA11());
    }

    public void add2(Matrix2x2 m) {
        a[0][0] = a[0][0] + m.getA00();
        a[0][1] = a[0][1] + m.getA01();
        a[1][0] = a[1][0] + m.getA10();
        a[1][1] = a[1][1] + m.getA11();
    }

    public Matrix2x2 sub(Matrix2x2 m) {
        return new Matrix2x2(a[0][0] - m.getA00(), a[0][1] - m.getA01(), a[1][0] - m.getA10(), a[1][1] - m.getA11());
    }

    public void sub2(Matrix2x2 m) {
        a[0][0] = a[0][0] - m.getA00();
        a[0][1] = a[0][1] - m.getA01();
        a[1][0] = a[1][0] - m.getA10();
        a[1][1] = a[1][1] - m.getA11();
    }

    public Matrix2x2 multNumber(double c) {
        return new Matrix2x2(a[0][0] * c, a[0][1] * c, a[1][0] * c, a[1][1] * c);
    }

    public void multNumber2(double c) {
        a[0][0] = a[0][0] * c;
        a[0][1] = a[0][1] * c;
        a[1][0] = a[1][0] * c;
        a[1][1] = a[1][1] * c;
    }

    //?
    public Matrix2x2 mult(Matrix2x2 m) {
        return new Matrix2x2(a[0][0] * m.getA00() + a[0][1] * m.getA10(), a[0][0] * m.getA01() + a[0][1] * m.getA11(),
                a[1][0] * m.getA00() + a[1][1] * m.getA10(), a[1][0] * m.getA01() + a[1][1] * m.getA11());
    }

    public void mult2(Matrix2x2 m) {
        a[0][0] = a[0][0] * m.getA00() + a[0][1] * m.getA10();
        a[0][1] = a[0][0] * m.getA01() + a[0][1] * m.getA11();
        a[1][0] = a[1][0] * m.getA00() + a[1][1] * m.getA10();
        a[1][1] = a[1][0] * m.getA01() + a[1][1] * m.getA11();
    }

    public double det() {
        return a[0][0] * a[1][1] - a[0][1] * a[1][0];
    }

    public void transpon() {
        double x = a[0][1];
        a[0][1] = a[1][0];
        a[1][0] = x;
    }

    public Matrix2x2 inverseMatrix() {
        double e[][] = new double[2][2];
        double b[][] = new double[2][2];

        b[0][0] = 1;
        b[0][1] = a[0][1] / (a[0][0]);
        e[0][0] = 1 / (a[0][0]);

        b[1][0] = a[1][0] - a[1][0] * b[0][0];
        b[1][1] = a[1][1] - a[1][0] * b[0][1];
        e[1][0] = 0 - a[1][0] * e[0][0];

        b[1][1] = 1;
        e[1][0] = e[1][0] / b[1][1];
        e[1][1] = 1 / b[1][1];

        b[0][1] = b[0][1] - b[1][1] * b[0][1];
        e[0][0] = e[0][0] - e[1][0] * b[0][1];
        e[0][1] = e[0][0] - e[1][1] * b[1][1];

        return new Matrix2x2(e[0][0], e[0][1], e[1][0], e[1][1]);

    }

    public Matrix2x2 equivalentDiagonal() {
        double b[][] = new double[2][2];
        b[0][0] = a[0][0] * a[1][0] / (double) (a[0][0]);
        b[0][1] = a[0][1] * a[1][0] / (double) (a[0][0]);

        b[1][0] = b[0][0] - a[1][0];
        b[1][1] = b[0][0] - a[1][1];

        b[1][1] = b[1][1] * b[0][1] / (double) (b[1][1]);

        b[0][0] = b[1][0] - b[0][0];
        b[0][1] = b[1][1] - b[0][1];

        return new Matrix2x2(b[0][0], b[0][1], b[1][0], b[1][1]);
    }

    public Vector2D multVector(Vector2D v) {
        return new Vector2D(a[0][0] * v.getX() + a[0][1] * v.getX(), a[1][0] * v.getY() + a[1][1] * v.getY());
    }

    public String toString() {
        return a[0][0] + ", " + a[0][1] + ", " + a[1][0] + ", " + a[1][1];
    }

    public boolean equals(Object obj) {
        Matrix2x2 m = (Matrix2x2) obj;
        return a[0][0] == m.getA00() && a[0][1] == m.getA01() && a[1][0] == m.getA10() && a[1][1] == m.getA11();
    }

    public double getA00() {
        return a[0][0];
    }

    public double getA01() {
        return a[0][1];
    }

    public double getA10() {
        return a[1][0];
    }

    public double getA11() {
        return a[1][1];
    }

}
