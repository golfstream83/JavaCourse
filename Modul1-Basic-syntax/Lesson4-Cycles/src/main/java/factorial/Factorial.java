package factorial;

public class Factorial
{
    private int value;

    public Factorial(int value)
    {
        this.value = value;
    }

    public static void main(String[] args)
    {
        Factorial factorial = new Factorial(Integer.valueOf(args[0]));
        System.out.println(String.format("Factorial of a given number is %s",factorial.calculation()));
    }

    public int calculation(){
        int result = 1;
        if (this.value == 0) {
            return result;
        }
        else
        {
            while (this.value != 0)
            {
                result *= this.value;
                this.value--;
            }
            return result;
        }
    }
}
