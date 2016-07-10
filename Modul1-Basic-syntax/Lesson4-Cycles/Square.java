package JavaCourse.Modul_1.Task_4_1;


public class Square
{
    private int a;
    private int b;
    private int c;

    public Square(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    float calculate (int x){
        float y = this.a * x * x + this.b * x + this.c;
        return y;
    }
}
