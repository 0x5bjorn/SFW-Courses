import java.util.*;

public class Problem1099 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		for (int i=0; i<a; ++i) {
			int b = input.nextInt();
			int c = input.nextInt();
			int total = 0;
			int n = 0;
			if (b > c) {
				n += c;
				while (n >= c && n < b-1) {
					++n;
					if (n % 2 != 0) {
						total += n;
					}
				}
			} else if (c > b) {
				n += b;
				while (n >= b && n < c-1) {
					++n;
					if (n % 2 != 0) {
						total += n;
					}
				}
			}
			System.out.println(total);
		}
	}
}