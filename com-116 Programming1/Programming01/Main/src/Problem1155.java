import java.util.*;

public class Problem1155 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US); 
		double a = 1;
		double b = 1;
		double c = a;
		double s = 0;
		while (b<101) {
			c = a/b;
			++b;
			s+=c;
		}
		System.out.printf("%.2f\n", s);
	}
}
