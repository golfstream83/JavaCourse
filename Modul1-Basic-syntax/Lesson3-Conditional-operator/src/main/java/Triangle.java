
import java.lang.Math;

public class Triangle
{
    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        //длины сторон
        double ab = this.a.distanceTo(this.b);
        double bc = this.b.distanceTo(this.c);
        double ca = this.c.distanceTo(this.a);

        //периметр
        double p = (ab + bc + ca) / 2;

        //calculate the triangle area
        double areaTriangle = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
        return areaTriangle;
    }

    public double getLenAB () {
        return this.a.distanceTo(this.b);
    }

    public double getLenBC () {
        return this.b.distanceTo(this.c);
    }

    public double getLenCA () {
        return this.c.distanceTo(this.a);
    }

    public double maxSideTriangle() {
        double ab = this.a.distanceTo(this.b);
        double bc = this.b.distanceTo(this.c);
        double ca = this.c.distanceTo(this.a);

        double maxSide = Math.max(ab, Math.max(bc, ca));

        return maxSide;
    }

}
