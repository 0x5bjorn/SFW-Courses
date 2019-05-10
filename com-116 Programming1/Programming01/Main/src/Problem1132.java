import java.util.*;

public class Problem1132 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int total = 0;
		int n = 0;
		if (a > b) {
			n += b;
			while (n >= b && n <= a) {
				if (n % 13 != 0) {
					total += n;
				}
				++n;
			}
			System.out.println(total);
		} else if (b > a) {
			n += a;
			while (n >= a && n <= b) {
				if (n % 13 != 0) {
					total += n;
				}
				++n;
			}
			System.out.println(total);
		}
	}
}
