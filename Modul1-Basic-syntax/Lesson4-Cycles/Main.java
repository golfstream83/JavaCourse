package JavaCourse.Modul_1.Task_4_1;


public class Main
{
    public static void main(String[] args)
    {
        Square square = new Square(Integer.valueOf(args[0]), Integer.valueOf(args[1]), Integer.valueOf(args[2]));
        for (int i = Integer.valueOf(args[3]); i <= Integer.valueOf(args[4]); ){
            System.out.println(square.calculate(i));
            i += Integer.valueOf(args[5]);
        }
    }
}
