import java.util.*;

public class FahrenheitCalculator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Temperature in degrees Fahrenheit? ");
		double f = input.nextDouble();
		
		double c = (f - 32) * 5/9;
		
		System.out.printf("The temperature in degrees Celsius is %.2f", c);
	}

}
