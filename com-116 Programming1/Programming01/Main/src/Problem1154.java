import java.util.*;

public class Problem1154 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US); 
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int i = 0;
		double aver = 0;
		while (a>0) {
			aver += a;
			++i;
			a = input.nextInt();
		}
		System.out.printf("%.2f\n", aver/i);
	}
}
