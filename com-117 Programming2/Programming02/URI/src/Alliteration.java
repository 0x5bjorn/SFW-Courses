import java.util.*;

public class Alliteration {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			String m = input.nextLine();
			countAl(m);
		}
	}
	
	static void countAl(String m) {
		int sum = 0;
		int a = 0;
		for (int i = 0; i < m.length(); i++) {
			a = m.indexOf(' ', i);
			if (i==0 && m.charAt(i) == m.charAt(a+1)) {
				sum++;
			}
			if (i==a) {
				a = m.indexOf(' ', i+1);
				if (m.charAt(i+1) == m.charAt(a+1)) {
					sum++;
					i=a;
				}
			}
		}
		System.out.println(sum);
	}
}
