package triangle;

public class Main
{
    public static void main(String[] args)
    {
        Point a = new Point(1, 1);
        Point b = new Point(3, 3);
        Point c = new Point(-20, 2);
        Triangle triangle = new Triangle(a, b, c);
        if ((triangle.getLenAB() + triangle.getLenBC()) > triangle.getLenCA() &&
                (triangle.getLenBC() + triangle.getLenCA()) > triangle.getLenAB() &&
                (triangle.getLenCA() + triangle.getLenAB()) > triangle.getLenBC())
        {
            System.out.println("Triangle area: " + triangle.area() + "\nThe length of the logest side: " +
                    triangle.maxSideTriangle());

        }
        else {
            System.out.println("A triangle can't be built.");
        }
    }
}
