import java.util.*;

public class Justifier {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int c = 0;
		while (true) {
			String a = input.nextLine();
			int a1 = Integer.parseInt(a);
			String[] arr = new String[a1];
			for (int i = 0; i < a1; ++i) {
				arr[i] = input.nextLine();
			}
			int max = 0;
			for (int i = 0; i < a1; ++i) {
				int b = arr[i].trim().length();
				if (max < b) {
					max = b;
				}
			}
			for (int i = 0; i < a1; ++i) {
				int t = max - arr[i].trim().length();
				for (int j = 0; j < t; ++j) {
					System.out.print(" ");
				}			
				System.out.println(arr[i]);
			}
			if (c>0) {
				System.out.println();
			}
			++c;
		}
	}
}