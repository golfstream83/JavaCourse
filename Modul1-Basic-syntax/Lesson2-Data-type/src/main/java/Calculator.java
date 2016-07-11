

public class Calculator {
	
	public double result;
	
	/*
	сложение двух чисел
	*/
	public void add (double first, double second) {
		this.result = first + second;
	}
	
	/*
	вычитание из числа first числа second
	*/
	public void substruct (double first, double second) {
		this.result = first - second;
	}
	
	/*
	деление числа first на число second
	*/
	public void div (double first, double second) {
		this.result = first / second;
	}
	
	/*
	умножение числа first на число second
	*/
	public void multiple (double first, double second) {
		this.result = first * second;
	}
	
	public void showResult() {
		System.out.printf("%s%f%n" ,"Result : ", this.result);
	}
}